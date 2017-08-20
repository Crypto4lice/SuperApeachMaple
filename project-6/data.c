#include<stdio.h>
// 링크드 리스트 (노드)
typedef struct node {
	int data;
	struct node* link;
}listnode;

typedef listnode* nodePtr;

listnode *create(int newdata);
void insert(listnode **head, listnode *prev, listnode *newnode);
void delete(listnode **head, listnode *target);
nodePtr search(listnode *head, int target);
void print(listnode *head);

//스택
#define MAX_SIZE 100

typedef enum {false, true} bool;
typedef struct _stack {
	int arr[MAX_SIZE];
	int top;
}stack;

stack stack1;

bool isempty(stack target);
bool isfull(stack target);
void push(stack *target, int data);
int pop(stack *target);
int peak(stack target);
void printStack(stack target);

//스택(노드)


typedef struct node_stack {
	int count;
	nodePtr top;
}nstack;

void init(nstack *target) {
	target->count = 0;
	target->top = NULL;
};

bool nisempty(nstack *head) {
	if (head == NULL)
		return true;
	else
		return false;
};
bool nisfull(nstack *head) {
	if (head->count == MAX_SIZE)
		return true;
	else
		return false;
};
void npush(nstack *target, int data) {
	
		nodePtr newnode = (nodePtr)malloc(sizeof(nodePtr));
		newnode->data = data;
		newnode->link = target->top;
		target->top = newnode;
		target->count++;
};
int npop(nstack *target) {
	int result=0;
	if (target->count > 0) {
		nodePtr temp = target->top;
		target->top = temp->link;
		result = temp->data;
		
		target->count--;
	}
	return result;
};
int npeak(nstack *target) {
	return target->top->data;
};
void nprintStack(nstack *target) {
	int i = 0;
	for (i = 0; i < target->count; i++) {
		printf("%d -> ", target->top->data);
		target->top = target->top->link;
	}
	printf("\n");
};


//큐(노드)
typedef struct node_queue {
	int count;
	nodePtr start;
	nodePtr end;
}nqueue;

void qinit(nqueue *target) {
	target->count = 0;
	target->start = NULL;
	target->end = NULL;
};


void qpush(nqueue *target, int data) {
	nodePtr newnode = (nodePtr)malloc(sizeof(nodePtr));
	newnode->data = data;
	newnode->link = NULL;
	if (target->start == NULL) {
		target->count++;
		target->start = newnode;
		target->end = newnode;
	}
	else {
		newnode->link = target->start;
		target->start = newnode;
		target->count++;
	}
};
int qpop(nqueue *target) {
	int result = 0;
	int i = 0;
	if (target->count == 0) {
		return result;
	}
	else {
		nodePtr point = (nodePtr)malloc(sizeof(nodePtr));
		result = target->end->data;
		point = target->start;
		while (i<target->count - 2) {
			point = point->link;
			i++;
		}
		target->end = point;
		point->link = NULL;
		target->count--;

		return result;
	}
};
void printQueue(nqueue *target) {
	nodePtr point = (nodePtr)malloc(sizeof(nodePtr));
	point = target->start;
	while (point != NULL) {
		printf("%d -> ", point->data);
		point = point->link;
	}
	printf("\n");
};

void main() {
	//링크드리스트(노드)
	/*

	listnode *list1 = (listnode *)malloc(sizeof(listnode));
	list1->link = NULL;

	listnode *a = create(11);
	listnode *b = create(22);

	insert(&list1, NULL, a);
	insert(&list1, NULL, b);
	insert(&list1, NULL, create(33));

	listnode *c = search(list1, 22);
	insert(&list1, c, create(98));

	delete(&list1, search(list1, 22));

	print(list1);

	//스택
	//printf("\n%d\n",isempty(stack1));
	//printf("\n%d\n", isfull(stack1));
	printf("\n");
	push(&stack1, 10);
	push(&stack1, 20);
	push(&stack1, 30);

	printStack(stack1);

	pop(&stack1);
	printStack(stack1);

	peak(stack1);
	printStack(stack1);
	//스택(노드)
	nstack *stack2 = (nstack *)malloc(sizeof(nstack));
	init(stack2);

	npush(stack2, 10);
	npush(stack2, 20);
	npush(stack2, 30);
	npush(stack2, 40);
	//npop(stack2);
	printf("%d\n",npop(stack2));
	nprintStack(stack2);

	*/
	//큐(노드)

	nqueue *queue = (nqueue *)malloc(sizeof(nqueue));

	qinit(queue);

	qpush(queue, 100);
	qpush(queue, 200);
	qpush(queue, 300);
	qpush(queue, 400);
	qpush(queue, 500);

	printf("%d\n",qpop(queue));
	
	printf("%d\n", qpop(queue));

	//printf("%d , %d \n", queue->start->data, queue->end->data);

	printQueue(queue);



	system("pause");
	//printf("0012312");
}

//링크드 리스트(노드)

listnode *create(int newdata) {
	listnode *newnode = (listnode*)malloc(sizeof(listnode));

	newnode->data = newdata;
	newnode->link = NULL;

	return newnode;
}

void insert(listnode **head, listnode *prev, listnode *newnode) {
	listnode *point;
	point = *head;
	while (point->link != NULL) {
		point = point->link;
	}

	if ((*head) == NULL) {
		newnode->link = NULL;
		(*head) = newnode;
	}
	else if (prev == NULL) {
		newnode->link = NULL;
		point->link = newnode;
	}
	else {
		newnode->link = prev->link;
		prev->link = newnode;
	}

}

void delete(listnode **head, listnode *target) {
	listnode *point;

	point = *head;

	while (point->link != NULL && point->link != target) {
		point = point->link;
	}
	if (point != NULL) {
		point->link = target->link;
	}
}

nodePtr search(listnode *head, int target) {
	listnode *point;
	point = head;
	listnode *res = NULL;

	while (point != NULL) {
		if (point->data == target)
			res = point;
		point = point->link;
	}

	return res;
}

void print(listnode *head) {
	listnode * point;
	
	point = head->link;

	while (point != NULL) {
		printf("%d -> ", point->data);
		point = point->link;
	}
}



//스택


bool isempty(stack target) {
	if (target.top == 0)
		return true;
	else
		return false;
}

bool isfull(stack target) {
	if (target.top == MAX_SIZE)
		return true;
	else
		return false;
}

void push(stack *target, int data) {
	if (target->top < MAX_SIZE) {
		target->arr[target->top] = data;
		target->top++;
	}	
}

int pop(stack *target) {
	if (target->top == 0)
		return 0;
	else {
		int result = 0;
		target->top--;
		result = target->arr[target->top];
		target->arr[target->top] = 0;

		return result;
	}
}

int peak(stack target) {
	if (target.top == 0)
		return 0;
	else {
		return target.arr[target.top - 1];
	}
}

void printStack(stack target) {
	int i = 0;
	for (i = 0; i < target.top; i++)
		printf("%d -> ", target.arr[i]);
	printf("\n");
}