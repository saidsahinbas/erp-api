package com.dev.thesisapi.controller;

import hex.genmodel.MojoModel;
import hex.genmodel.easy.EasyPredictModelWrapper;
import hex.genmodel.easy.RowData;
import hex.genmodel.easy.prediction.MultinomialModelPrediction;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/api/predict")
public class PredictionController {

    private final EasyPredictModelWrapper model;

    public PredictionController() throws Exception {
        this.model = new EasyPredictModelWrapper(MojoModel.load("src/main/resources/DRF_model_python_1737059637636_2.zip"));
    }

    @PostMapping
    public String predict(@RequestBody Map<String, Object> features) throws Exception {
        RowData row = new RowData();
        row.put("total_order_count", features.get("total_order_count").toString());
        row.put("total_success_order_count", features.get("total_success_order_count").toString());
        row.put("sample_size", features.get("sample_size").toString());
        row.put("success_sample_size", features.get("success_sample_size").toString());
        row.put("order_status_1", features.get("order_status_1").toString());
        row.put("order_status_2", features.get("order_status_2").toString());
        row.put("order_status_3", features.get("order_status_3").toString());

        MultinomialModelPrediction prediction = (MultinomialModelPrediction) model.predict(row);

        return String.format("Predicted label: %s, Probabilities: %s",
                prediction.label, Arrays.toString(prediction.classProbabilities));
    }
}
