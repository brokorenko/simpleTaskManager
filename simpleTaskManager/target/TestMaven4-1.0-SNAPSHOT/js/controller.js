/*app.controller('showProjectsController', function($scope, $http) {*/
  /*  $scope.headingTitle = "Show Projectsss";*/
    /*$scope.project = "sstatic project"*/
/*    $http.get('getProjects.htm')
        .success(function (data) {
            $scope.project = data;
    });*/



/*}); */


app.controller('showProjectsController', function($scope, $http) {
    $http.get("/getProjects")
        .then(function(response) {
            //First function handles success
            $scope.headingTitle = "Show Projects";
            $scope.project = response.data;
        }, function(response) {
            //Second function handles error
            $scope.project = "Something went wrong";
            $scope.headingTitle = "Error";
        });
});
app.controller('createProjectController', function($scope, $window, $http) {
    //$scope.data = {};
    $scope.projectFromForm = {'project_name' : ''};
    $scope.submit = function () {
        $scope.messages = [];

        alert($scope.projectFromForm.project_name);
        // AngularJS will populate this object with input
        // values based on the data-ng-model mappings.

        $http.post("/createProject", $scope.projectFromForm)
            .then(function(data, status, headers, config) {
                //First function handles success
                $scope.project = data.data;
                $window.location.replace('projects.html')
            }, function(data, status, headers, config) {
                //Second function handles error
                if(status == 400) {
                    $scope.messages = data;
                } else {
                    alert('Unexpected server error. Sorry' + status);
                }
            });
    }
});

app.controller('showTasksController', function($scope, $http) {
    $http.get("/getTasks")
        .then(function(response) {
            //First function handles success
            $scope.headingTitle = "Show Tasks";
            $scope.tasks = response.data;
        }, function(response) {
            //Second function handles error
            $scope.project = "Something went wrong";
            $scope.headingTitle = "Error";
        });
});

app.controller('createTaskController', function($scope, $window, $http) {
    //$scope.data = {};
    $scope.taskFromForm = {'task_name' : '', 'project_id' : ''};
    $scope.submit = function () {
        $scope.messages = [];

        // AngularJS will populate this object with input
        // values based on the data-ng-model mappings.

        $http.post("/createTask", $scope.taskFromForm)
            .then(function(data, status, headers, config) {
                //First function handles success
                $scope.tasks = data.data;
                $window.location.replace('tasks.html')
            }, function(data, status, headers, config) {
                //Second function handles error
                if(status == 400) {
                    $scope.messages = data;
                } else {
                    alert('Unexpected server error. Sorry' + status);
                }
            });
    }
});

app.controller('findDeveloperController', function($scope, $window, $http) {
    //$scope.data = {};
    $scope.developer = {'user_full_name' : ''};
    $scope.submit = function () {
        $scope.messages = [];

        $http.post("/findDeveloper", $scope.developer)
            .then(function(data, status, headers, config) {
                //First function handles success
                $window.location.replace('tasks.html');
                $scope.tasks = data.data;
            }, function(data, status, headers, config) {
                //Second function handles error
                if(status == 400) {
                    $scope.messages = data;
                } else {
                    alert('Unexpected server error. Sorry' + status);
                }
            });
    }
});