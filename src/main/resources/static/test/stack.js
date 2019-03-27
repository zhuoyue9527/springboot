function Stack(){
	var items =[]; //私有变量
	
	// 从栈顶添加一个元素， 压栈
	this.push = function(item){
		items.push(item);
	}
	
	//弹出栈顶元素
	this.pop =function(){
		return items.pop();
	}
	
	//返回栈顶元素
	this.top = function(){
		return items[items.length -1];
	}
	
	//判断栈是否为空
	this.isEmpty = function(){
		return items.length == 0;
	}
	
	//返回栈的大小
	this.size = function(){
		return items.length ;
	}
	
	//清空栈
	this.clear = function(){
		return items =[] ;
	}
}
//用栈表示队列
function queueByStack(){
	var stack_1 = new Stack() ;
	var stack_2 = new Stack() ;
	
	
	this.enqueue = function(data){
		stack_1.push(data);
	}
	
	this.dequeue = function(){
		if(!stack_2.isEmpty){
			return stack_2.pop();
		}else{
			if(stack_1.isEmpty){
				return null ;
			}
			while(!stack_1.isEmpty){
				stack_2.push(stack_1.pop());
			}
		}
		return stack_2.pop();
		
	}
	
	this.head = function(){
		if(stack_2.isEmpty){
			if(stack_1.isEmpty){
				return null ;
			}
			while(!stack_1.isEmpty){
				stack_2.push(stack_1.pop());
			}
			
		}
		return stack_2.top();
	}
	
	this.tail = function(){
		
	}
	
	
}


//计算后缀表达式
function calc_exp(exp){
	var stack =new Stack();
	
	for(var i =0 ;i<exp.length ;i++){
		var item = exp[i];
		if(["+","-","*","/"].indexOf(item) >= 0){
			var value_1 = stack.pop();
			var value_2 = stack.pop();
			var exp_str = value_2 + item + value_1;
			//计算并取证
			var res =parseInt(eval(exp_str));
			//入站
			stack.push(res.toString());
			
		}else{
			stack.push(item);
		}
	}
	return stack.pop();
}
console.log(calc_exp( ["4","13","5","/","+"] ));
console.log(eval("3+4"));


//判断字符里的括号是否合法
function is_leagl_brackets(string){
	var stack =new Stack();
	
	for(var i =0 ;i<string.length ;i++){
		var item = string[i];
		//遇到左括号入站栈
		if(item =="("){
			stack.push(item);
		}else if(item ==")"){
			//遇到右括号 判断是否为空
			if(stack.isEmpty()){
				return false;
			}else{
				stack.pop();
			}
		}
	}
	return stack.isEmpty();
}

console.log(is_leagl_brackets("sdf(ds(ew(we)rw)ds)we"));
console.log(is_leagl_brackets("sdf(ds"));


