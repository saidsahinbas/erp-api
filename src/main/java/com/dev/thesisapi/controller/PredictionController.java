package com.dev.thesisapi.controller;

import com.dev.thesisapi.service.PredictionService;
import hex.genmodel.MojoModel;
import hex.genmodel.easy.EasyPredictModelWrapper;
import hex.genmodel.easy.RowData;
import hex.genmodel.easy.prediction.MultinomialModelPrediction;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/predict")
public class PredictionController {

    private final EasyPredictModelWrapper model;
    private final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) throws Exception {
        this.model = new EasyPredictModelWrapper(MojoModel.load("src/main/resources/DRF_model_python_1737059637636_2.zip"));
        this.predictionService = predictionService;
    }

    @PostMapping("/analyze-and-predict")
    public Object analyzeAndPredict(@RequestBody Map<String, String> filters) throws Exception {
        Object analysisResult = predictionService.filterAndCalculate(filters.get("supplierId"), filters.get("productId"));

        if (analysisResult instanceof Map) {
            // Tek bir sonuç varsa direkt tahmin yap
            return makePrediction((Map<String, Object>) analysisResult);
        } else if (analysisResult instanceof List) {
            // Liste döndürülmüşse her bir öğe için tahmin yap
            return ((List<Map<String, Object>>) analysisResult)
                    .stream()
                    .map(this::makePrediction)
                    .toList();
        } else {
            throw new IllegalStateException("Unexpected result type");
        }
    }


    private Map<String, Object> makePrediction(Map<String, Object> features) {
        // ImmutableMap'i mutable bir Map'e dönüştür
        Map<String, Object> mutableFeatures = new HashMap<>(features);

        RowData row = new RowData();
        mutableFeatures.forEach((key, value) -> row.put(key, value.toString()));

        try {
            MultinomialModelPrediction prediction = (MultinomialModelPrediction) model.predict(row);

            // Add prediction to the result
            mutableFeatures.put("predicted_label", prediction.label);
            mutableFeatures.put("probabilities", Arrays.toString(prediction.classProbabilities));
        } catch (Exception e) {
            mutableFeatures.put("error", "Prediction failed: " + e.getMessage());
        }

        return mutableFeatures;
    }

}
