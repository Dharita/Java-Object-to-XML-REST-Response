'use strict'

var module = angular.module('demo.controllers', []);
module.controller("UserController", [ "$scope", "UserService",
		function($scope, UserService) {

			$scope.userDto = {
				userId : null,
				userName : null,
				skillDtos : []
			};
			$scope.skills = [];
			
			UserService.getUserById(1).then(function(value) {
				console.log(value.data);
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});
			
			UserService.getJson().then(function(value) {
				$scope.jsonRequired= value.data;
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});
			
			$scope.getJson = function() {
				UserService.getJson().then(function(value) {
					console.log("works", value.data);
					$scope.cst= value.data;
					var cst = value.data;
					$scope.axesCount = cst.axes.length;
					$scope.colDimCount = cst.axes[0].positions[0].memberDimensionCaptions.length;
					$scope.rowDimCount = cst.axes[1].positions[0].memberDimensionCaptions.length;
					$scope.rowCount = cst.axes[1].positions.length + $scope.colDimCount;
					$scope.colCount = cst.axes[0].positions.length;
					$scope.totalColCount = $scope.colCount + $scope.rowDimCount;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}

			$scope.saveUser = function() {
				$scope.userDto.skillDtos = $scope.skills.map(skill => {
					return {skillId: null, skillName: skill};
				});
				UserService.saveUser($scope.userDto).then(function() {
					console.log("works");
					UserService.getAllUsers().then(function(value) {
						$scope.allUsers= value.data;
					}, function(reason) {
						console.log("error occured");
					}, function(value) {
						console.log("no callback");
					});

					$scope.skills = [];
					$scope.userDto = {
						userId : null,
						userName : null,
						skillDtos : []
					};
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}
		} ]);