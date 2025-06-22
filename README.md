<!DOCTYPE html>
<html lang="en">
<head>
  
</head>
<h1>            <span style="font-size:2.5rem; font-weight:bold;">Car Dealership API</span> </h1>

 <h3>Front Page</h3>



 
 ![Screenshot 2025-06-21 184711](https://github.com/user-attachments/assets/fab2c017-ed9e-4974-a6f8-9bd189f97c8e)






























'



<body>
  <div class="header">
    <img src="https://cdn-icons-png.flaticon.com/512/743/743007.png" alt="Car Logo"/>
    <div style="margin-top:10px;">A RESTful Java Spring Boot</div>
  </div>
  <div class="container">
    <h2>🚗 Overview</h2>
    <p>
      <span class="badge">Backend</span>
      This project is a Spring Boot REST API for a car dealership. It allows you to manage <strong>vehicles</strong>, <strong>dealerships</strong>, <strong>inventory</strong>, <strong>sales contracts</strong>, and <strong>lease contracts</strong>.<br>
      <b>Features:</b> Full CRUD, search by parameters, tested with Postman.
    </p>
    <h2>✨ Key Endpoints</h2>
    <ul>
      <li><code>GET /vehicles</code> – List all vehicles</li>
      <li><code>GET /vehicles/search?make=Toyota&minPrice=5000</code> – Search vehicles by query params</li>
      <li><code>POST /vehicles</code> – Add a new vehicle</li>
      <li><code>PUT /vehicles/{id}</code> – Update a vehicle</li>
      <li><code>DELETE /vehicles/{id}</code> – Delete a vehicle</li>
      <li><code>GET /sales-contracts/{id}</code> – Get sales contract by ID</li>
      <li><code>POST /sales-contracts</code> – Add a new sales contract</li>
      <li>And more for inventory, dealerships, lease contracts!</li>
    </ul>
    <h2>⚙️ Technologies Used</h2>
    <ul>
      <li>Java 24, Spring Boot 3.5</li>
      <li>MySQL</li>
      <li>RESTful API design</li>
      <li>Tested via Postman</li>
    </ul>
    <h2>📬 Example Search</h2>
    <pre>
GET /vehicles/search?make=Toyota&minYear=2022&maxPrice=15000
    </pre> 
    <h2>🚦 Status</h2>
    <p>
      <span class="badge">Complete</span>
      All core endpoints are implemented and tested!
    </p>
    <div style="text-align:center; margin-top:40px; font-size:1.1em; color:#999;">
      &copy; 2025 Car Dealership API | Made with ❤️ in Seattle
    </div>
  </div>
</body>
</html>

