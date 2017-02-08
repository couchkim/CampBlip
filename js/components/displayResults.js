module.exports = {

    name: 'displayResults',
    object: {

        templateUrl: 'templates/displayResults.html',
        bindings: {
            item: '<',
            onClick: '&', 
        },
        controller: 'displayResultsController',
    }

}