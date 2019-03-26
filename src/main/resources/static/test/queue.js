function Queue(){
	var items = [] ;
	
	//向尾部添加元素
	this.enqueue = function(item){
		items.push(item);
	}
	
	//一处头部元素
	this.dequeue = function(){
		return items.shift();
	}
	
	//返回头部元素
	this.head = function(){
		return items[0];
	}
	
	//返回队列尾部元素
	this.tail = function(){
		return items[items.length -1];
	}
	
	//返回长度
	this.size = function(){
		return items.length ;
	}
	
	//清空
	this.clear = function(){
		items =[];
	}
	
	this.isEmpty = function(){
		return item.length == 0 ;
	}
}

function fibonacci(n){
	var queue = new Queue();
	queue.enqueue(1);
	queue.enqueue(1);
	
	var index = 0;
	while(index < n-2){
		var value1 = queue.dequeue();
		var value2 = queue.head();
		var str = value1 + value2 ;
		queue.enqueue(str);
		index += 1 ;
	}
	
	queue.dequeue();
	return queue.head();
	
}
console.log(fibonacci(6));


//用两个队列表现一个栈
function stackByqueue(){
	var queue1 = new Queue();
	var queue2 = new Queue();
	
	var data = null ;
	var empty = null ;
	
	var initfunction = function(){
		if(queue1.isEmpty && queue2.isEmpty ){
			data = queue1 ;
			empty = queue2 ;
		}else if( queue1.isEmpty && !queue2.isEmpty ){
			data = queue2 ;
			empty = queue1 ;
		}else{
			data = queue1 ;
			empty = queue2 ;
		}
	}	
	this.push = function(item){
		initfunction();
		data.enqueue(item);
		
	}
	this.pop = function(){
		initfunction();
		while(data.size() != 1){
			empty.enqueue(data.dequeue());
		}
		return data.dequeue();
	}
	this.top = function(){
		initfunction();
		return data.tail();
	}
}
console.log(stackByqueue(6));