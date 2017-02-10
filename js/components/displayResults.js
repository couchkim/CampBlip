module.exports = {

    name: 'displayResults',
    object: {

        templateUrl: 'components/displayResults.html',
        bindings: {
            item: '<',
            onClick: '&', 
        },
        controller: 'displayResultsController',
    }

}