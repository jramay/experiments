<html>
   <head>
   <script src = "main/lib/angular.js"></script>
   <script src = "main/mainApp.js"></script>
   <script src = "common/dataService.js"></script>
   <script src = "main/mainController.js"></script>
   <title>AngularJS First Application</title>
   </head>
   
   <body>
      <h1>My Application</h1>
      
      <div ng-app="mainApp">
      <form ng-submit="getMessage()" ng-controller="mainController">
         <p>Enter your Name: <input type = "text" ng-model = "name"></p>
         <button ng-click="getMessage()">Get Message</button>
         <p>Message : {{message}}</p>
         </div>
      </div>
   </body>
</html>