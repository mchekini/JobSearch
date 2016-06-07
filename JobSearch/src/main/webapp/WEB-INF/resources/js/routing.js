<<<<<<< HEAD
'use strict';


app.config(['$routeProvider', function($routeProvider){
    $routeProvider
    .when('/annonces',
    		{
    	controller : 'lister_annonces',
    	templateUrl: 'angular/views/AnnoncesView.html'})
}]);
=======
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
>>>>>>> 1f2ace4aa53494069d4d55581c88175e82cbd64e
