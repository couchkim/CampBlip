(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
const app = angular.module('CampApp', ['ui.router']);
// const app = angular.module('CampApp', ['ui.router'], ['ngEmbed']);


app.config(function ($stateProvider) {

    $stateProvider.state({
        name: 'home-page',
        url: '/home',
        component: 'homePage',
    });

    // home page for the site

    $stateProvider.state({
        name: 'admin-page',
        url: '/admin',
        component: 'adminPage',
    });

    // admin page will be landing page after successful login too

    $stateProvider.state({
        name: 'register-page',
        url: '/register',
        component: 'registerPage',
    });

    // register for a camp session

    $stateProvider.state({
        name: 'sets-page',
        url: '/sets',
        component: 'setsPage',
    });

    // search for sets

    $stateProvider.state({
        name: 'details-page',
        url: '/details/:single',
        component: 'detailsPage',
    });

    // see details on a single set

    $stateProvider.state({
        name: 'parts-page',
        url: '/parts/:single',
        component: 'partsPage',
    });

    // see all parts for a single set

    $stateProvider.state({
        name: 'account-page',
        url: '/account',
        component: 'accountPage',
    });

    // handles login or create new account

    $stateProvider.state({
        name: 'instructions-page',
        url: '/instructions/:single',
        component: 'instructionsPage',
    });

    $stateProvider.state({
        name: 'home',
        url: '',
        component: 'homePage',
    });

});


const controllers = [
    require('./controllers/homePageController'),
    require('./controllers/adminPageController'),
    require('./controllers/setsPageController'),
    require('./controllers/registerPageController'),
    require('./controllers/displayResultsController'),
    require('./controllers/detailsPageController'),
    require('./controllers/partsPageController'),
    require('./controllers/accountPageController'),
    require('./controllers/instructionsPageController'),



];

for (let i = 0; i < controllers.length; i++) {
    console.log(controllers[i].name)
    app.controller(controllers[i].name, controllers[i].func);
};

const components = [
    require('./components/homePage'),
    require('./components/adminPage'),
    require('./components/setsPage'),
    require('./components/registerPage'),
    require('./components/displayResults'),
    require('./components/detailsPage'),
    require('./components/partsPage'),
    require('./components/accountPage'),
    require('./components/instructionsPage'),


];

for (let i = 0; i < components.length; i++) {
    app.component(components[i].name, components[i].object);
};

const services = [
    require('./services/CampService'),
];

for (let i = 0; i < services.length; i++) {
    console.log(services[i].name)
    app.factory(services[i].name, services[i].func);
};




},{"./components/accountPage":2,"./components/adminPage":3,"./components/detailsPage":4,"./components/displayResults":5,"./components/homePage":6,"./components/instructionsPage":7,"./components/partsPage":8,"./components/registerPage":9,"./components/setsPage":10,"./controllers/accountPageController":11,"./controllers/adminPageController":12,"./controllers/detailsPageController":13,"./controllers/displayResultsController":14,"./controllers/homePageController":15,"./controllers/instructionsPageController":16,"./controllers/partsPageController":17,"./controllers/registerPageController":18,"./controllers/setsPageController":19,"./services/CampService":20}],2:[function(require,module,exports){
module.exports = {

    name: 'accountPage',
    object: {

        templateUrl: 'templates/accountPage.html',
        bindings: {
            // label: '<', 

        },
        controller: 'accountPageController',
    }

}
},{}],3:[function(require,module,exports){
module.exports = {

    name: 'adminPage',
    object: {

        templateUrl: 'templates/adminPage.html',
        bindings: {
            // label: '<', 

        },
        controller: 'adminPageController',
    }

}
},{}],4:[function(require,module,exports){
module.exports = {

    name: 'detailsPage',
    object: {

        templateUrl: 'templates/detailsPage.html',
        bindings: {
            
        },
        controller: 'detailsPageController',
    }

}


},{}],5:[function(require,module,exports){
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
},{}],6:[function(require,module,exports){
module.exports = {

    name: 'homePage',
    object: {

        templateUrl: 'templates/homePage.html',
        bindings: {
            // label: '<', 

        },
        controller: 'homePageController',
    }

}
},{}],7:[function(require,module,exports){
module.exports = {

    name: 'instructionsPage',
    object: {

        templateUrl: 'templates/instructionsPage.html',
        bindings: {
            // item: '<',
            // onClick: '&', 
        },
        controller: 'instructionsPageController',
    }

}
},{}],8:[function(require,module,exports){
module.exports = {

    name: 'partsPage',
    object: {

        templateUrl: 'templates/partsPage.html',
        bindings: {
            // item: '<',
            // onClick: '&', 
        },
        controller: 'partsPageController',
    }

}

},{}],9:[function(require,module,exports){
module.exports = {

    name: 'registerPage',
    object: {

        templateUrl: 'templates/registerPage.html',
        bindings: {
            // label: '<', 

        },
        controller: 'registerPageController',
    }

}
},{}],10:[function(require,module,exports){
module.exports = {

    name: 'setsPage',
    object: {

        templateUrl: 'templates/setsPage.html',
        bindings: {
            // label: '<', 

        },
        controller: 'setsPageController',
    }

}
},{}],11:[function(require,module,exports){
module.exports = {

    name: "accountPageController",
    func: function ($scope, CampService) {

         console.log('account page controller working');
            
        

    },
}
},{}],12:[function(require,module,exports){
module.exports = {

    name: "adminPageController",
    func: function ($scope, CampService) {

       
            console.log('admin page controller working');
        

    },
}
},{}],13:[function(require,module,exports){
module.exports = {

    name: "detailsPageController",
    func: function ($scope, CampService, $stateParams) {

       const id = ($stateParams.single);
       console.log("hello");
       $scope.item = CampService.getSet(id);
       console.log($scope.item);

            console.log('detail page controller working');
        

    },
}




},{}],14:[function(require,module,exports){
module.exports = {

    name: "displayResultsController",
    func: function ($scope, CampService) {

       
            console.log('display results controller working');
        

    },
}




},{}],15:[function(require,module,exports){
module.exports = {

    name: "homePageController",
    func: function ($scope, CampService) {

         console.log('home page controller working');
            
        

    },
}
},{}],16:[function(require,module,exports){
module.exports = {

    name: "instructionsPageController",
    func: function ($scope, CampService, $stateParams) {

       const partSet = ($stateParams.single);
       console.log("parts");
       $scope.partSet = CampService.getSet(partSet);
       console.log($scope.partSet);

       $scope.instructions = $scope.partSet.instructions;
       console.log($scope.instructions);
            console.log('parts page controller working');
        

    },
}
},{}],17:[function(require,module,exports){
module.exports = {

    name: "partsPageController",
    func: function ($scope, CampService, $stateParams) {

       const partSet = ($stateParams.single);
       console.log("parts");
       $scope.partSet = CampService.getSet(partSet);
       console.log($scope.partSet);

       $scope.parts = $scope.partSet.parts;
       console.log($scope.parts);
            console.log('parts page controller working');
        

    },
}


},{}],18:[function(require,module,exports){
module.exports = {

    name: "registerPageController",
    func: function ($scope, CampService) {

         console.log('register page controller working');
            
        

    },
}
},{}],19:[function(require,module,exports){
module.exports = {

    name: "setsPageController",
    func: function ($scope, CampService) {


// all of these arrays will be populated from the initial page load JSON response

        $scope.levels = ['Beginner', 'Intermediate', 'Advanced', 'Expert'];

        $scope.available = ['Available', 'Checked Out', 'Missing Pieces', 'On Display'];

        $scope.themes = ['Advanced Models', 'Agents', 'Alien Conquest', 'Aqua Raiders', 'Architecture', 'Atlantis', 'Batman', 'Bionicle', 'Cars2', 'Castle',
            'Chima', 'City', 'Creator', 'Dino', 'Friends', 'Galaxy Squad', 'Ghostbusters', 'Harry Potter', 'Hero Factory', 'Hobbit', 'Ideas', 'Indiana Jones', 'Lego Movie',
            'Lone Ranger', 'Lord of the Rings', 'Mars Mission', 'Minecraft', 'Monster Fighters', 'Ninjago', 'Power Miners', 'Prince of Persia', 'Racers', 'Scooby Doo', 'Space Police',
            'Speed Champions', 'Spongebob', 'Sports', 'Star Wars', 'Super Heroes', 'Technic', 'Teenage Mutant Ninja Turtles',
            'The Simpsons', 'Toy Story', 'Ultra Agents', 'Vintage', 'Wall-E'];

        $scope.viewSets = function () {
            $scope.sets = CampService.getSets();
            console.log($scope.sets);
        };





        console.log('sets page controller working');



    },
}
},{}],20:[function(require,module,exports){
module.exports = {

    name: "CampService",
    func: function ($http) {


        function Set(name, number, theme, pieces, status, image, year) {
            this.setName = name;
            this.setNumber = number;
            this.theme = theme;
            this.pieces = pieces;
            this.status = status;
            this.image = image;
            this.year = year;
            this.skill = null;
            // array with beginner, etc.
            this.invDate = '4/20/2016';
            // last inventoried date
            this.invName = 'Marshall';
            // who inventoried it
            this.invNeed = 'No';
            // Boolean t or f for needs inventory
            this.lastCheckout = '8/10/2015';
            // last date that set was checked out
            this.invParts = 100;
            // how many parts we had after inventory
            this.missing = 5;
            // number of pieces missing from the set
            this.order = 'lots of pieces';
            // text string from admin input
            this.notes = 'many notes to share';
            // text string from admin input
            this.parts = [
                {name: 'antennae',
                color: 'black',
                id: '123456',
                photo:'https://i.stack.imgur.com/xCxdq.jpg',
                setQuantity: 3,
                invQuantity: 3,
            },
            {name: 'antennae longer name',
                color: 'black',
                id: '123456',
                photo:'https://i.stack.imgur.com/xCxdq.jpg',
                setQuantity: 3,
                invQuantity: 3,
            },
            {name: 'antennae',
                color: 'black',
                id: '123456',
                photo:'https://i.stack.imgur.com/xCxdq.jpg',
                setQuantity: 3,
                invQuantity: 3,
            }
            ];
            // array of all parts in the set that comes when parts button is clicked
            this.instructions = 'https://mi-od-live-s.legocdn.com/bigdownloads/buildinginstructions/4617445.pdf';


            return this;
        };


        let sets = [];

        sets.push(new Set('Space Moon Buggy', '3365-1', 'City', 37, 'Available', 'http://images.brickset.com/sets/images/3365-1.jpg?201012090229', 2005));
        sets.push(new Set('The First Night', '21115-1', 'Minecraft', 408, 'Checked Out', 'http://images.brickset.com/sets/large/21115-1.jpg?201410080618', 2014));
        sets.push(new Set('The Batcave', '6860-1', 'Super Heroes', 690, 'Missing Pieces', 'http://images.brickset.com/sets/images/6860-1.jpg?201110150701', 2013));
        sets.push(new Set('Death Star', '10188-1', 'Star Wars', 3803, 'On Display', 'http://images.brickset.com/sets/AdditionalImages/10188-1/10188-0000-xx-13-1.jpg', 2015));
        sets.push(new Set('Yellow Submarine', '21306-1', 'Ideas', 553, 'Checked Out', 'http://images.brickset.com/sets/images/21306-1.jpg?201610150938', 2017));

        console.log(sets);

        return {

            getSets() {

                $http.get("https://camp-blip-legos.herokuapp.com/sets").then(function (response) {
                    console.log(response);

                });

                return sets;
            },

            getSet(id){

                for (let i = 0; i < sets.length; i++){
                    if (sets[i].setNumber === id){
                        return sets [i];
                    }
                }
            },

        }
    },
};


},{}]},{},[1]);
