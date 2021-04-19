# ClientService
This is a basic AWS EBS example for Java .

As you know AWS Elastic Beanstalk is for deploying and scaling web applications and services developed
with a lot of programming languages.


We have 3 basic microservices projects , respectively Add,Subctract and client services. Client service includes add and substract services. It just works as a view layer.

Basically , if you want to calculate  , it just simply calls rest api and result will be on the browser.

1) First thing we need to do , just deploy AddService and SubService to EBS(Elastic Bean Stalk).
2) After that , we can take our apis of our services, and so we need to implement these api adresses into ClientService.
3) Finally, We can deploy ClientService to EBS . And then test it. If  you have  take any errors, just change your code , and build your war files. And then upload 
your environment in EBS.

4)You need to make sure that platform have to be Tomcat, as you have war files .




