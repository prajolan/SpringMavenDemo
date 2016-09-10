<%-- 
    Document   : AngularTest
    Created on : Sep 2, 2016, 8:00:05 AM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--Angular JS app,ng-app, we can also keep this on the body tag-->
<html ng-app="myApp" ng-controller="controller as c">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!--CDN for Angular JS-->
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    </head>
    <body>
        <h1>Hello World11111!</h1>
        <p>{{2 + 2}}</p>
        FirstName: <input type="text" ng-model="c.firstName"/>
        LastName: <input type="text" ng-model="c.lastName"/>
        <p>{{c.fullName();}}</p>

        <button ng-click="c.sayHello();">Hello</button>
        <p ng-bind="c.message"></p>

        <!--ng-bind also does the same function as the above function-->
        <!--<p ng-bind="firstName"></p>-->
        <script>
                    angular.module('myApp', [])
                    .controller('controller', [function(){
                    var self = this;
                            self.firstName = "Hari";
                            self.lastName = "Prasad";
                            self.fullName = function(){
                            return self.firstName + " " + self.lastName;
                            }
                    self.sayHello = function(){

                    return  self.message = "Good Morning" + " " + self.fullName();
                    }




                    }]);        </script>
    </body>
</html>
