## Price Prediction Engine

The `PricePredictionService`: - Loads CSV data - Trains a simple
regression/heuristic model - Exposes `/api/predict`

Example Request:

``` json
{
  "area": 1200,
  "bedrooms": 3,
  "bathrooms": 2,
  "furnishingStatus": "FURNISHED",
  "mainroad": true,
  "parking": 1,
  "prefarea": false
}
```

Example Response:

``` json
{
  "predictedPrice": 112500
}
```

------------------------------------------------------------------------

## Running Tests

    mvn test

Includes: - Unit tests for services - Integration test with H2
database - Prediction model test