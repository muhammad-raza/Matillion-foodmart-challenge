This project is developed using spring boot jpa using maven as build tool.

Maven is shipped with the project as I was not sure if HakerRank has maven built-in

Clone the repository and import project as maven or from existing source. 

you can run following command to build project and import dependencies

```
sh install.sh
```  

####Running Program
You call run this program locally by running following command from home directory
```
sh run.sh
```
This will compile, install and execute the program.

####Testing
To run all unit tests combined you can run following command from home directory
```
sh test.sh
```
Most of the code is covered by unit tests. Integration test is *missing* as I think this code would be enough to assess knowledge. 
Integration test for `FoodmartService` can be written by setting up in-memory H2 database.

####Enhancement
There were quite a few limitations in this program due to its requirement to 
print data on command line. Enhancement can be made by converting it to REST API service.
`e.g @Get /Department/{id}` will bring all employees in the department and
 
`@GET /employee?department=Store Management&pay_type=Monthly&education_level=Bachelors Degree`
 
would achieve same results.
