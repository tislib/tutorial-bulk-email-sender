Pros and cons of Async implementation


1. Api Consumer(Whoever uses our API) must wait until Email is sent.
2. We are using Spring Web Threads for sending Email. 1000 email, 200 Spring Threads
3. We don't have any recover mechanism


Easiest way
1. We can use ThreadPool, we can immediate call it. - Executing in Parallel Thread
2. We can store it in Database(EmailMessage), and another thread can get them from DB and execute. - Batch option
3. We can use MB (RabbitMq, Kafka) - Streaming option
