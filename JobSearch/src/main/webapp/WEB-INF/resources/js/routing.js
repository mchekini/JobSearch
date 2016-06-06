/**
 *  MAHDI CHEKINI
 */

'use strict';

app.config(function($routeProvider)
		{
	$routeProvider
	             .when('/',{
	            	 templateUrl : 'angular/Views/authentification.html'
	             })
	             .when('/annonces/',{
	            	 controller : 'lister_annonces',
	            	 templateUrl : 'angular/Views/liste_annonces.html'
	             })
		});