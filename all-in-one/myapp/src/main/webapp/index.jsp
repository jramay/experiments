<html>
   <head>
   <script src = "lib/angular.js"></script>
   <title>AngularJS First Application</title>
   </head>
   
   <body>
      <h1>My Application</h1>
      
      <div ng-app = "">
         <p>Enter your Name: <input type = "text" ng-model = "name"></p>
         <p>Hello <span ng-bind = "name"></span>!</p>
      </div>
   </body>
</html>