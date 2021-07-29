# Yelp-Demo
REST API for accessing yelp reviews of the Red Oak Grille

## Usage 

### Request

`GET /reviews'

### URL Params

| parameter     | description                |
| ------------- | -------------------------- |
| num           | maximum number of reviews  |
| start         | review to start on         |

### Response

    HTTP/1.1 200 OK
    Date: Thu, 29 Jul 2021 01:58:17 GMT
    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json

    [{
      "author": "George K.",
      "datePublished": "2021-05-28",
      "reviewRating": {
        "ratingValue": 5
      },
      "description": "Most recent visit was great , we enjoyed it. Service was good ,a bit slow due to large groups. We love the food, people, great experience.\n\nThe view is as usual very good."
    },
    {
      "author": "Robert P.",
      "datePublished": "2020-08-31",
      "reviewRating": {
        "ratingValue": 5
      },
      "description": "I&apos;ve been here several times with family and enjoyed myself every outing. Service is fantastic, prompt and helpful. \nThey did temperature checks before seating us outside on the patio recently and had hand sanitizer at each table (pictured). The view is really lovely seeing the golf course and hills a few miles out.\nFood was delicious, and cooked to everyone&apos;s requests. The burger was fantastic, great quality meat and the fries were hearty and still crispy/hot. Will for sure be back, definitely worth trying out in the area!"
    }]

### Scaping / API

By default, uses JSoup to scrape the review data from the Red Oak Grille yelp page. By modifying the 'review.retrieve.method' property, this code can instead use Yelp's public REST API https://www.yelp.com/developers/documentation/v3. (See table)

| review.retrieve.method     | description                          |
| -------------------------- | ------------------------------------ |
| webScrapper                | uses webscrapper to get review data  |
| api                        | uses Yelp API to get review data     |
