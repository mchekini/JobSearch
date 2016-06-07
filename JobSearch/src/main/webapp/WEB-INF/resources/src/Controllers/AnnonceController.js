'use strict';



app
   .controller('lister_annonces',function($scope,AnnonceProvider){
   
   $scope.annonces = AnnonceProvider.getAnnonces() ;
   
   
   })
   .controller('creer_annonce',function($scope)
   {
   
   
   
   })
   .controller('delete_annonce',function($scope){
   
   
   
   
   
   });