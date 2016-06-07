'use strict';


app.config(['$routeProvider', function($routeProvider){
    $routeProvider
    .when('/annonces',
    		{
    	controller : 'lister_annonces',
    	templateUrl: 'angular/views/AnnoncesView.html'})
}]);