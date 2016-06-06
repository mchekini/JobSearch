'use strict';

app.directive('decorate',function()
		{
		return 
		{
	template: 'id annonce = {{ann.id}} , titre du poste = {{ann.titre}}'
		}
		})