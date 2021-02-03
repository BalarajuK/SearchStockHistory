angular.module('StockSearchApp',[]).controller('StockSearchCtrl',function($scope, $http)
{
    $scope.company = "IDEA";

    $scope.searchFunction = function () {
        var url = "search/trading";
        url = url + "?company=" + $scope.company;

        $http.get(url).then(function (response) {
            $scope.stocks = response.data;
        });
    }
});