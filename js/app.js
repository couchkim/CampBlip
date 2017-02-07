const app = angular.module('CampApp', ['ui.router']);

app.config(function ($stateProvider) {

    $stateProvider.state({
        name: 'home-page',
        url: '/home',
        component: 'homePage',
    });

    $stateProvider.state({
        name: 'admin-page',
        url: '/admin',
        component: 'adminPage',
    });

    $stateProvider.state({
        name: 'sets-page',
        url: '/sets',
        component: 'setsPage',
    });

    $stateProvider.state({
        name: 'register-page',
        url: '/register',
        component: 'registerPage',
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



