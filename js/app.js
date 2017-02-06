const app = angular.module('CampApp', ['ui.router']);

app.config(function ($stateProvider) {
    
    $stateProvider.state({
        name: 'home-page',
        url: '/home',
        component: 'homePage',
    });
});


const controllers = [
    require('./controllers/homePageController'),
   

];

for(let i = 0; i < controllers.length; i++){
    console.log(controllers[i].name)
    app.controller(controllers[i].name, controllers[i].func);
};

const components = [
    require('./components/homePage'),
    

];

for(let i = 0; i < components.length; i++){
    app.component(components[i].name, components[i].object);
};

const services = [
    require('./services/CampService'),
];

for(let i = 0; i < services.length; i++){
    console.log(services[i].name)
    app.factory(services[i].name, services[i].func);
};



