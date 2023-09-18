# Async-Project
비동기 적용기 : Async ▶ WebFlux ▶ KAFKA

## 📌사용 기술
- Java 17
- JPA
- QueryDSL
- MySQL
- WebFlux
- Kafka(예정)

## 📌과정
### 1️⃣ Spring Event 사용 + 비동기
<!--![image](https://github.com/acrnm148/Async-Project/assets/67724306/fdf1dc43-5107-4a2b-8ec4-f5504ed3919a)-->
<!--![image](https://github.com/acrnm148/Async-Project/assets/67724306/c2c72a20-aa10-4f5e-bfcb-5114ed86337f)-->
![image](https://github.com/acrnm148/Async-Project/assets/67724306/bb1f92fc-9495-4eee-acb1-e79552d41e68)

- corePoolSize를 5개로 설정하여 쓰레드 5개가 동시에 요청을 처리한다.
<br/><br/>

### 2️⃣ AsyncConfig
![image](https://github.com/acrnm148/Async-Project/assets/67724306/b970c830-6acd-425b-bc95-711404e7c3d3)

- 동시에 동작하는 쓰레드 개수 corePoolSize
- corePoolSize가 다 찼을 때 동시에 동작하는 최대 쓰레드 개수 maxPoolSize
- corePoolSize가 다 찼을 때 요청이 큐에 쌓이고, maxPoolSize가 다 찼을 때 요청이 큐에 쌓일 때 큐에 넣을 수 있는 요청의 개수 queueCapacity
- 요청을 처리하기 위한 쓰레드가 쓰레드풀에 들어가지 못해 발생하는 RejectedExecutorException 발생 시 처리되는 작업을 설정하였다.
   -> new ThreadExecutor.CallerRunsPolicy() 로 쓰레드풀이 다 찼을 경우 요청을 받은 쓰레드에서 동기로 처리하도록 설정해주었다.
<br/><br/>


### 3️⃣ WebFlux




### 4️⃣ Kafka




## 📌느낀점


## 📓 개발과정
### 블로그 URL : [블로그 - 비동기](https://k-ang.tistory.com/category/Web/%EB%B9%84%EB%8F%99%EA%B8%B0)
