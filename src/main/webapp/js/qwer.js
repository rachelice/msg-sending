//这个js放置经常用到的方法
//遍历json
var json = {
	name:'贤心',
	sex:'男',
	age:'23'
}
for(i in json){
	console.log(i+':'+json[i]);
	//alert(i+':'+json[i])
}
//result
//name:贤心
//sex:男
//age:23

console.log(" %s + %s ", 1, 1, "= 2")
//1 + 1  = 2

var languages = [
    { name: "JavaScript", fileExtension: ".js" },
    { name: "TypeScript", fileExtension: ".ts" },
    { name: "CoffeeScript", fileExtension: ".coffee" }
];

console.table(languages);
//index)	name	fileExtension
//0	"JavaScript"	".js"
//1	"TypeScript"	".ts"
//2	"CoffeeScript"	".coffee"

//为false则输出
console.assert(list.childNodes.length < 500, "Node count is > 500");

//这两个方法用于计时，可以算出一个操作所花费的准确时间。
console.time("Array initialize");

var array= new Array(1000000);
for (var i = array.length - 1; i >= 0; i--) {
    array[i] = new Object();
};

console.timeEnd("Array initialize");

// Array initialize: 1914.481ms
console.dir//：输出对象的信息，用于显示一个对象的所有属性。

console.clear//：对console窗口进行清屏，光标回到第一行。

console.trace//：当前执行的代码在堆栈中的调用路径。

//debugger语句的作用是，当代码运行到这一行时，就会暂停运行，自动打开console界面。
//它通常用于代码除错，作用类似于设置断点。
for(var i = 0;i<5;i++){
    console.log(i);
    if (i===2) debugger;
}
