# Product Service
## Endpoints
### Save Product
````
POST /api/product HTTP
Host: localhost:8080
Content-Type: application/json

{
    "name": "TEst-1",
    "price": 0.0
}
````
### Get Products
````
GET /api/product HTTP
Host: localhost:8080
Content-Type: application/json

{
    "id": 1,
    "name": "TEst-1",
    "price": 0.0,
    "createTime": "2023-08-03T20:27:16.043665"
}
````
### Update Product
````
PUT /api/product/productId HTTP
Host: localhost:8080
Content-Type: application/json

{
    "id": 1,
    "name": "TEst-1",
    "price": 0.0
}
````
### Delete Product
````
DELETE /api/product/productId HTTP
Host: localhost:8080
````
