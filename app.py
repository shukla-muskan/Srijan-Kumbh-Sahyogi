from flask import Flask, request, jsonify
import pickle

app = Flask(__name__)

# Load the trained model
with open("model.pkl", "rb") as file:
    model = pickle.load(file)

@app.route("/predict", methods=["POST"])
def predict():
    data = request.json  # Assuming data is sent as JSON
    input_features = data.get("features")  # Example: [5.1, 3.5, 1.4, 0.2]
    
    prediction = model.predict([input_features])
    return jsonify({"prediction": prediction[0]})

if __name__ == "__main__":
    app.run(debug=True, host="0.0.0.0", port=5000)
