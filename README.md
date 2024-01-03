Bulk Email Sender
========

Youtube Video: https://www.youtube.com/watch?v=m941WwMeP88

# Plan
1. Simple Email Sender with Spring with persisting option + Sendgrid 
2. Async mail sender
3. Bulk Email Sender
4. Async mail sender with Kafka topics and scaling
5. Email priorities

# API Design

## Email Message API

```http request
POST /api/v1/email-messages
Content-Type: application/json

{
  "from": "contact@apibrew.io",
  "to": "talehsmail@gmail.com",
  "subject": "Test subject",
  "body": "Test Body"
}

```

## Bulk Email Message API

```http request
POST /api/v1/bulk-email-messages
Content-Type: application/json

{
  "from": "contact@apibrew.io",
  "to": ["talehsmail@gmail.com", "talehsmail@gmail.com"],
  "subject": "Test subject",
  "body": "Test Body"
}

```