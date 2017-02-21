(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
const app = angular.module('CampApp', ['ui.router']);


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
        name: 'about-page',
        url: '/about',
        component: 'aboutPage',
    });

    $stateProvider.state({
        name: 'parties-page',
        url: '/parties',
        component: 'partiesPage',
    });

    $stateProvider.state({
        name: 'home',
        url: '',
        component: 'homePage',
    });

});


const controllers = [
    require('./controllers/adminPageController'),
    require('./controllers/setsPageController'),
    require('./controllers/detailsPageController'),
    require('./controllers/partsPageController'),
    require('./controllers/accountPageController'),
    require('./controllers/instructionsPageController'),
];

for (let i = 0; i < controllers.length; i++) {
    app.controller(controllers[i].name, controllers[i].func);
};

const components = [
    require('./components/homePage'),
    require('./components/adminPage'),
    require('./components/setsPage'),
    require('./components/registerPage'),
    require('./components/displayResults'),
    require('./components/detailsPage'),
    require('./components/displayCatalog'),
    require('./components/partsPage'),
    require('./components/accountPage'),
    require('./components/instructionsPage'),
    require('./components/aboutPage'),
    require('./components/partiesPage'),

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




},{"./components/aboutPage":2,"./components/accountPage":3,"./components/adminPage":4,"./components/detailsPage":5,"./components/displayCatalog":6,"./components/displayResults":7,"./components/homePage":8,"./components/instructionsPage":9,"./components/partiesPage":10,"./components/partsPage":11,"./components/registerPage":12,"./components/setsPage":13,"./controllers/accountPageController":14,"./controllers/adminPageController":15,"./controllers/detailsPageController":16,"./controllers/instructionsPageController":17,"./controllers/partsPageController":18,"./controllers/setsPageController":19,"./services/CampService":20}],2:[function(require,module,exports){
module.exports = {

    name: 'aboutPage',
    object: {

        templateUrl: 'components/aboutPage.html',
        bindings: {
            

        },
        
    }

};
},{}],3:[function(require,module,exports){
module.exports = {

    name: 'accountPage',
    object: {

        templateUrl: 'components/accountPage.html',
        bindings: {
            // label: '<', 

        },
        controller: 'accountPageController',
    }

}
},{}],4:[function(require,module,exports){
module.exports = {

    name: 'adminPage',
    object: {

        templateUrl: 'components/adminPage.html',
        bindings: {
            
        },
        controller: 'adminPageController',
    }

}
},{}],5:[function(require,module,exports){
module.exports = {

    name: 'detailsPage',
    object: {

        templateUrl: 'components/detailsPage.html',
        bindings: {
            
        },
        controller: 'detailsPageController',
    }

}


},{}],6:[function(require,module,exports){
module.exports = {

    name: 'displayCatalog',
    object: {

        templateUrl: 'components/displayCatalog.html',
        bindings: {
            info: '<',
            onChange: '&', 
        },
       
    }

}
},{}],7:[function(require,module,exports){
module.exports = {

    name: 'displayResults',
    object: {

        templateUrl: 'components/displayResults.html',
        bindings: {
            item: '<',
            onClick: '&', 
        },
       
    }

}
},{}],8:[function(require,module,exports){
module.exports = {

    name: 'homePage',
    object: {

        templateUrl: 'components/homePage.html',
        bindings: {
    
        },
        
    }

}
},{}],9:[function(require,module,exports){
module.exports = {

    name: 'instructionsPage',
    object: {

        templateUrl: 'components/instructionsPage.html',
        bindings: {
            // item: '<',
            // onClick: '&', 
        },
        controller: 'instructionsPageController',
    }

}
},{}],10:[function(require,module,exports){
module.exports = {

    name: 'partiesPage',
    object: {

        templateUrl: 'components/partiesPage.html',
        bindings: {
            
        },
    },

}

},{}],11:[function(require,module,exports){
module.exports = {

    name: 'partsPage',
    object: {

        templateUrl: 'components/partsPage.html',
        bindings: {
            // item: '<',
            // onClick: '&', 
        },
        controller: 'partsPageController',
    }

}

},{}],12:[function(require,module,exports){
module.exports = {

    name: 'registerPage',
    object: {

        templateUrl: 'components/registerPage.html',
        bindings: {
           
        },
    }

}
},{}],13:[function(require,module,exports){
module.exports = {

    name: 'setsPage',
    object: {

        templateUrl: 'components/setsPage.html',
        bindings: {
            

        },
        controller: 'setsPageController',
    }

}
},{}],14:[function(require,module,exports){
module.exports = {

    name: "accountPageController",
    func: function ($scope, $http, CampService) {


  const self = this

  const authenticate = function(credentials, callback) {

    const headers = credentials ? {authorization : "Basic "
        + btoa(credentials.username + ":" + credentials.password)
    } : {};

    $http.get('user', {headers : headers}).then(function(response) {
      if (response.data.name) {
        $scope.authenticated = true;
      } else {
        $scope.authenticated = false;
      }
      callback && callback();
    }, function() {
      $scope.authenticated = false;
      callback && callback();
    });

  }

  authenticate();
  self.credentials = {};
  self.login = function() {
      authenticate(self.credentials, function() {
        if ($scope.authenticated) {
          $location.path("/");
          self.error = false;
        } else {
          $location.path("/login");
          self.error = true;
        }
      });
  };
            
        

    },
}
},{}],15:[function(require,module,exports){
module.exports = {

    name: "adminPageController",
    func: function ($scope, CampService) {


        $scope.setNumber = '';
        $scope.setId = '';
        $scope.newCamper = '';
        $scope.weeks = '';
        $scope.newInfo = null;
        $scope.partySet = '';
        $scope.partySets = null;
        $scope.allPartySetInfo = null;



        $scope.newSet = function () {
            CampService.addSet($scope.setNumber).then(function (response) {
                $scope.newInfo = response;
                console.log(response);
            });

            console.log($scope.newInfo);
            $scope.setNumber = '';

        };

        $scope.removeSet = function () {

            CampService.deleteSet($scope.setId);
        };

        $scope.addCamper = function () {
            CampService.newCamper($scope.newCamper, $scope.weeks);
        };

        $scope.newPartySet = function (set) {
            $scope.partySets = CampService.addPartySet(set);

        };

        $scope.createPartyCatalog = function () {
            CampService.getPartyInfo($scope.partySets).then(function (response) {
                $scope.allPartySetInfo = response;
                console.log($scope.allPartySetInfo);
            })


        }


    },
}
},{}],16:[function(require,module,exports){
module.exports = {

    name: "detailsPageController",
    func: function ($scope, CampService, $stateParams) {


        // $scope.campers = ['Wilson Rhee', 'Carter Bateman', 'Collier McElroy',
        //     'Alexander Paschal', 'Holden Harrell'];

        // $scope.camperList = '';
        $scope.newNote = '';
        $scope.byStatus = '';
        $scope.statusList = [];
        // $scope.item.statusDisplay = '';
        // $scope.item.statusDisplay = $scope.item.status;


        const id = parseInt($stateParams.single);

        // Getting specific set so that details for just that set are displayed
        CampService.getSet(id).then(function (response) {
            $scope.item = response;
            console.log($scope.item);
        });


        // When click Check In or Check Out button it toggles the button and changes the status
        $scope.checkToggle = function () {
            $scope.item.status = CampService.changeStatus($scope.item.setId, $scope.item.status);
            // if($scope.item.status === "CHECKED_OUT"){
            //     $scope.item.statusDisplay = "Checked Out"
            // in get set function, not here
            // }
        }


        // Getting list of status options from database
        CampService.getFilters().then(function (response) {
            $scope.statusList = response.status;
            console.log(response);
        });

        // Updating database with admin notes or admin change to status
        $scope.updateSet = function (item) {
            CampService.sendUpdate(item.setId, $scope.byStatus, $scope.newNote);
        }

    },
}




},{}],17:[function(require,module,exports){
module.exports = {

    name: "instructionsPageController",
    func: function ($scope, $sce, $http, CampService, $stateParams) {

        const partSet = ($stateParams.single);
        console.log("parts");

        $scope.partSet = CampService.getSet(partSet);
        console.log($scope.partSet);

        $scope.instructions = $scope.partSet.instructions;
       
    },
}
},{}],18:[function(require,module,exports){
module.exports = {

    name: "partsPageController",
    func: function ($scope, CampService, $stateParams) {

        const partSet = ($stateParams.single);
        console.log("parts");

        CampService.getSet(partSet).then(function (response) {

            $scope.partSet = response;
            $scope.parts = $scope.partSet.parts;
         
            CampService.showParts(response);
        });

        $scope.partQty = '';

        $scope.changeQty = function (set, part) {
            part.currInv = part.setQty;
            CampService.updateQty(set, part.setPartId, part.currInv);
            console.log(set, part.setPartId, part.currInv);

        };

        $scope.sendQty = function (set, part) {
            CampService.updateQty(set, part.setPartId, part.currInv);
            console.log(set, part.setPartId, part.currInv);

        };

        $scope.finalQty = function (set) {
            CampService.submitInv(set);


        };

        $scope.checkAll = function () {
            if ($scope.selectedAll) {
                $scope.selectedAll = true;
            } else {
                $scope.selectedAll = false;
            }
            angular.forEach($scope.parts, function (part) {
                part.Selected = $scope.selectedAll;
                $scope.changeQty(part.setId, part);
            });

        };



    },
}


},{}],19:[function(require,module,exports){
module.exports = {

    name: "setsPageController",
    func: function ($scope, CampService) {

// These are the filters for the search
        $scope.levels = [];
        $scope.available = [];
        $scope.themes = [];

// These are the inputs and dropdown selections from the search
        $scope.byName = '';
        $scope.byNumber = '';
        $scope.byTheme = '';
        $scope.byLevel = '';
        $scope.byStatus = '';
        $scope.filters = '';

// Gets filters from database and populates empty arrays above
        CampService.getFilters().then(function (response) {
            $scope.levels = response.skills;
            $scope.available = response.status;
            $scope.themes = response.themes;

            console.log(response);
        });


// Gets all sets when the Show All Sets button is clicked
        $scope.viewSets = function () {
            $scope.sets = CampService.getSets();
            console.log($scope.sets);
        };

// Gets sets after Search for Sets button is clicked based on the filters selected
        $scope.viewSearchSets = function () {
            $scope.sets = CampService.getSearchSets($scope.byName, $scope.byNumber,
                $scope.byTheme, $scope.byLevel, $scope.byStatus);
            
            console.log($scope.sets);
        };


    },
}
},{}],20:[function(require,module,exports){
module.exports = {

    name: "CampService",
    func: function ($http) {


        function Set(id, name, number, theme, pieces, status, image, year, skill, invDate, invName,
            invStat, invParts, checkout, instructions, notes) {
            this.setId = id;
            this.setName = name;
            this.setNumber = number;
            this.theme = theme;
            this.pieces = pieces;
            this.status = status;
            this.image = image;
            this.year = year;
            this.skill = skill;
            // array with beginner, etc.
            this.invDate = invDate;
            // last inventoried date
            this.invName = invName;
            // who inventoried it
            this.invStat = invStat;
            // three possible states
            this.lastCheckout = checkout;
            // last date that set was checked out
            this.invParts = invParts;
            // how many parts we had after inventory
            this.missing = 0;
            // number of pieces missing from the set
            this.notes = notes;
            // text string from admin input
            this.parts = [];
            // array of all parts in the set that comes when parts button is clicked
            this.instructions = instructions;


            return this;
        };


        let sets = [];
        let partySets = [];
        let partySetInfo = [];
        console.log(partySets);

        return {

            // Gets all sets from database and pushes them through the Set constructor and into the sets array
            // Returns the array of sets.
            getSets() {

                $http.get("/sets").then(function (response) {
                    // $http.get("https://camp-blip-legos.herokuapp.com/sets").then(function (response) {
                    console.log(response);


                    for (let i = 0; i < response.data.setViews.length; i++) {
                        let item = response.data.setViews;
                        item[i] = new Set(item[i].set_id, item[i].name, item[i].set_num, item[i].theme,
                            item[i].num_parts, item[i].status, item[i].set_img_url, item[i].year,
                            item[i].skill_level, item[i].inv_date, item[i].inv_name, item[i].inv_stat, item[i].inv_parts,
                            item[i].last_checkout, item[i].set_build_url, item[i].notes);

                    }
                    angular.copy(response.data.setViews, sets);


                });

                return sets;
            },

            // Gets the lists of filters for the search dropdowns, returns a promise and the response
            getFilters() {
                return $http.get("/filters/").then(function (response) {
                    console.log(response);
                    return response.data;
                })
            },

            // Gets the sets that match the search filters, puts them through the constructor and into the sets array for display
            // Returns the sets array/
            getSearchSets(nameFilter, numFilter, themeFilter, levelFilter, statFilter) {
                $http.get("/sets/?setName=" + nameFilter + "&setNum=" + numFilter + "&theme=" + themeFilter + "&status=" + statFilter + "&skill=" + levelFilter).then(function (response) {

                    console.log(response);


                    for (let i = 0; i < response.data.setViews.length; i++) {
                        let item = response.data.setViews;
                        item[i] = new Set(item[i].set_id, item[i].name, item[i].set_num, item[i].theme,
                            item[i].num_parts, item[i].status, item[i].set_img_url, item[i].year,
                            item[i].skill_level, item[i].inv_date, item[i].inv_name, item[i].inv_stat, item[i].inv_parts,
                            item[i].last_checkout, item[i].set_build_url, item[i].notes);
                    }
                    angular.copy(response.data.setViews, sets);
                });

                return sets;
            },

            getSet(id) {

                return $http.get("/set/" + id).then(function (response) {
                    let item = response.data.setViews[0];
                    item = new Set(item.set_id, item.name, item.set_num, item.theme,
                        item.num_parts, item.status, item.set_img_url, item.year,
                        item.skill_level, item.inv_date, item.inv_name, item.inv_stat, item.inv_parts,
                        item.last_checkout, item.set_build_url, item.notes);
                    console.log(response);
                    return item;
                })
            },

            addSet(num) {

                return $http.post("/add-set/" + num).then(function (response) {
                    console.log(response);
                    return response.data;
                })
            },


            showParts(item) {
                $http.get("/parts/" + item.setId).then(function (response) {
                    angular.copy(response.data.parts, item.parts)
                    console.log(response);
                })
            },


            changeStatus(set, status) {

                if (status === "AVAILABLE") {
                    status = "CHECKED_OUT";
                    // return status;
                } else {
                    status = "AVAILABLE";
                };
                $http.post("/set/status/" + set + "/?status=" + status).then(function (response) {
                });
                return status;
            },


            updateQty(set, id, update) {
                const array = [id, update];
                $http.post("/parts/" + set, array)
                    .then(function (response) {
                        console.log(response);

                    })
            },

            submitInv(set) {
                const array = [9999, 9999];
                $http.post("/parts/" + set, array)
                    .then(function (response) {
                        console.log(response);

                    })
            },

            sendUpdate(id, status, note) {
                const data = [status, note];
                $http.post("/set/" + id, data)
                    .then(function (response) {
                        console.log(response);

                    })
            },

            addPartySet(set) {
                partySets.push(set);
                return partySets;
            },


            getPartyInfo(array) {
               return $http.get("/sets").then(function (response) {

                    console.log(response);

                    for (let i = 0; i < response.data.setViews.length; i++) {
                        let item = response.data.setViews;
                        for (let j = 0; j < array.length; j++) {
                            if (parseInt(array[j]) === parseInt(item[i].set_num)) {
                                partySetInfo.push(new Set(item[i].set_id, item[i].name, item[i].set_num, item[i].theme,
                                    item[i].num_parts, item[i].status, item[i].set_img_url, item[i].year,
                                    item[i].skill_level, item[i].inv_date, item[i].inv_name, item[i].inv_stat, item[i].inv_parts,
                                    item[i].last_checkout, item[i].set_build_url, item[i].notes));   
                            }    
                        }
                    }
                    console.log(partySetInfo);
                    return partySetInfo;

                });

                return sets;

            },

            deleteSet(id) {
                // $http.delete("/parts/" + id).then(function (response) {

                //     console.log(response);
                // })
            },

            newCamper(person, time) {
                // $http.post("/campers/").then(function (response) {

                //     console.log(response);
                // })
            },

        };

    },
};


},{}]},{},[1]);
