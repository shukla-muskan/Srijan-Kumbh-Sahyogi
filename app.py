from flask import Flask, request, jsonify
import pickle
import os

app = Flask(__name__)

# Load both models
with open('medicine_name_predictor.pkl', 'rb') as f:
    medicine_model = pickle.load(f)

with open('fever_medicine_predictor.pkl', 'rb') as f:
    fever_model = pickle.load(f)

# Root route
@app.route('/')
def home():
    return "ML model is running"

# Route 1: Predict general medicine
@app.route("/predict", methods=["POST"])
def predict():
    data = request.json
    input_season = data.get("Season")

    # Step 1: Validate season
    allowed_seasons = ['Fall' 'Spring' 'Summer' 'Winter']
    if input_season not in allowed_seasons:
        return jsonify({"error": f"Invalid season. Allowed: {allowed_seasons}"}), 400

    # Step 2: Predict
    prediction = model.predict([{"Season": input_season}])
    return jsonify({"predicted_medicine": prediction[0]})


# Route 2: Predict medicine for fever
@app.route('/predict-fever', methods=['POST'])
def predict_fever():
    data = request.get_json()
    if 'features' not in data:
        return jsonify({'error': 'Missing features'}), 400

    features = data['features']
    prediction = fever_model.predict([features])
    return jsonify({'prediction': prediction.tolist()})

if __name__ == '__main__':
    port = int(os.environ.get('PORT', 5000))
    app.run(debug=True, host='0.0.0.0', port=port)
