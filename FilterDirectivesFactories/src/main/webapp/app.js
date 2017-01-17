angular.module('examApp', [])
  .controller('ExamController', ['$scope', function($scope) {
          $scope.hey = "hey";
  console.log("hey");
    var studentsInfo = {};
    studentsInfo.allCourses = [
      {courseId : 1000,courseName: "Basic Programming"},
      {courseId : 1001,courseName: "Advanced Programming"},
      {courseId : 1003,courseName: "DataBase Intro"}];
    console.log("hey");
    studentsInfo.students = [];
    studentsInfo.students.push({studentId : 100, name: "Peter Hansen", grades : [{grade: "10"},{grade: "12"},{}]});
    studentsInfo.students.push({studentId : 101, name: "Jan Olsen", grades : [{grade: "7"},{grade: "10"},{}]});
    studentsInfo.students.push({studentId : 102, name: "Gitte Poulsen", grades : [{grade: "7"},{grade: "7"},{}]});
    studentsInfo.students.push({studentId : 103, name: "John McDonald", grades : [{grade: "10"},{},{grade: "7"}]});
      console.log("hey");
  }]).filter('average', function(){
    return function (grades){
      var sum = 0;
      var temp = 0;
      for (var i = 0; i < grades.length; i++){
          if(grades[i].grade > -4){
              sum = sum + parseInt(grades[i].grade);
              temp++;
          }
      }
      return sum / temp;
    };
  });