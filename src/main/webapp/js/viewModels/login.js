define([ 'knockout', 'appController', 'ojs/ojmodule-element-utils', 'accUtils',
		'jquery' ], function(ko, app, moduleUtils, accUtils, $) {

	class LoginViewModel {
		constructor() {

			var self = this;
			
			self.userName = ko.observable("pepe");
			self.pwd = ko.observable("pepe");
			self.message = ko.observable();
			self.error = ko.observable();



			self.googleUser = undefined
			
			// Header Config
			self.headerConfig = ko.observable({
				'view' : [],
				'viewModel' : null
			});
			moduleUtils.createView({
				'viewPath' : 'views/header.html'
			}).then(function(view) {
				self.headerConfig({
					'view' : view,
					'viewModel' : app.getHeaderModel()
				})
			})
		}

		login() {
			var self = this;
			if (self.googleUser){
				info = {
					name: self.googleUser.getBasicProfile().getName(),
					email: self.googleUser.getBasicProfile().getEmail(),
					id: self.googleUser.getBasicProfile().getId(),
					type: 'google',
				};
			}else{
				var info = {
					name : this.userName(),
					pwd : this.pwd()
				};
			}

			console.log(info)

			var data = {
				data : JSON.stringify(info),
				url : "user/login",
				type : "post",
				contentType : 'application/json',
				success : function(response) {
					app.router.go( { path : "games"} );
				},
				error : function(response) {
					self.error(response.responseJSON.errorMessage);
				}
			};
			$.ajax(data);
		}
		
		register() {
			app.router.go( { path : "register" } );
		}

		connected() {
			accUtils.announce('Login page loaded.');
			document.title = "Login";

			var self = this;
			let divGoogle = document.createElement('div');
			divGoogle.setAttribute('id', 'my-signin2');
			document.getElementById('zonaGoogle').appendChild(divGoogle);

			gapi.signin2.render('my-signin2', {

				scope: 'profile email',
				width: 200,
				height: 75,
				longtitle: false,
				theme: 'dark',
				onsuccess: function (response) {
					self.googleUser = response;
					self.login();
				},
				onfailure: function (error) {
					console.log(error);
					self.googleUser = undefined;
				},
			});

		};

		disconnected() {
			gapi.auth2.getAuthInstance().disconnect();
		};

		transitionCompleted() {
			// Implement if needed
		};
	}



	return LoginViewModel;
});
