from flask import Flask, request, jsonify
import pickle

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
@app.route('/predict-medicine', methods=['POST'])
def predict_medicine():
    data = request.get_json()
    if 'features' not in data:
        return jsonify({'error': 'Missing features'}), 400
    
    features = data['features']
    prediction = medicine_model.predict([features])
    return jsonify({'prediction': prediction.tolist()})

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
    app.run(debug=True)

