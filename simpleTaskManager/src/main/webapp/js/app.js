var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/projects',{
            templateUrl: 'html/projects.html',
            controller: 'showProjectsController'
        })
        .when('/createProject',{
            templateUrl: 'html/createProject.html',
            controller: 'createProjectController'
        })
        .when('/tasks',{
            templateUrl: 'html/tasks.html',
            controller: 'showTasksController'
        })
        .when('/createTask',{
            templateUrl: 'html/createTask.html',
            controller: 'createTaskController'
        })
        .when('/findDeveloper',{
            templateUrl: 'html/findDeveloper.html',
            controller: 'findDeveloperController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

