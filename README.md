<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Car Dealership API - Project README</title>
  <style>
    body { font-family: 'Segoe UI', Arial, sans-serif; background: #f7faff; margin: 0; color: #222; }
    .header { background: linear-gradient(90deg, #2274a5, #20b2aa); color: #fff; padding: 30px 0; text-align: center; border-radius: 0 0 30px 30px; }
    .header img { height: 60px; vertical-align: middle; margin-right: 15px;}
    h1 { margin-bottom: 0; }
    .container { max-width: 800px; margin: 30px auto; background: #fff; box-shadow: 0 0 12px #b3d1e6; border-radius: 15px; padding: 32px; }
    h2 { color: #2274a5; }
    ul { line-height: 1.7; }
    code, pre { background: #f3f3f3; color: #2d5871; border-radius: 6px; padding: 2px 6px; }
    .badge { display: inline-block; background: #ffb400; color: #222; padding: 3px 10px; border-radius: 7px; margin-right: 7px;}
    a { color: #20b2aa; }
  </style>
</head>
<body>
  <div class="header">
    <img src="https://cdn-icons-png.flaticon.com/512/743/743007.png" alt="Car Logo"/>
    <span style="font-size:2.5rem; font-weight:bold;">Car Dealership API</span>
    <div style="margin-top:10px;">A RESTful Java Spring Boot Backend</div>
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
