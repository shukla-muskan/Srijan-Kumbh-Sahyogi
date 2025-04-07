# Srijan-Kumbh-Sahyogi
Repository for hackathon

🌐 Tech Stack for Sahyogi
💻 Frontend
React.js – For building responsive web dashboards

Tailwind CSS – Fast styling with utility classes

Axios – For making API calls to the backend

🔙 Backend
Java (Spring Boot) – To build secure RESTful APIs

Handles user roles: Admin, SHG, Villager

Routes for alerts, medicine prediction, vehicle listing

🧠 Machine Learning
Python + XGBoost (XGBClassifier) – For predicting medicines based on disease/symptom

Flask – Lightweight Python framework to serve the ML model via API

Pandas + Scikit-learn – For data processing and evaluation

🛢 Database
MySQL – Stores user data, medicine records, SHG info, and logistics entries

🔒 Authentication
Spring Security – Role-based access control

🧪 Testing
Postman – API testing

JUnit (Spring) – For backend logic testing

💾 Version Control
Git + GitHub – Team collaboration and code versioning



🌊 System Flow of Sahyogi
🔸 1. User Interaction (Frontend)
Admin logs in and views region-wise medicine stock, SHG status, and vehicle pool

SHG logs in to receive demand alerts and can register available logistics (vehicles)

Villagers (or Sub-admins) can raise medicine demand requests or view medicine availability

➡ All user actions trigger API calls to the Spring Boot backend via Axios

🔸 2. Backend Logic (Java Spring Boot)
Authenticates users via Spring Security

Handles core modules:

Medicine Request Handling

Demand Forecast Alert Distribution

Vehicle Listing & Search

Communicates with:

MySQL database (for persistent storage)

Python ML service (to fetch predictions based on demand data)

🔸 3. ML Prediction (Python + XGBoost)
Disease/season/month sent from backend via REST API

Flask app loads XGBoost model and returns the predicted medicine

Spring Boot uses this prediction to:

Trigger alerts to relevant SHG groups

Update demand chart in Admin Dashboard

🔸 4. Logistics Management
SHGs can list their own vehicles (with type & availability)

Other SHGs/Admins can request/rent based on region-wise needs

All entries stored and fetched via MySQL

🔁 Overall Flow Summary
User → React Frontend → Spring Boot API

Spring Boot → Python ML API (XGBoost) → Prediction

Prediction → Stored & Displayed → SHG Notified

SHG → Provides Medicine & Logistics
