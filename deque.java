package application;



import java.util.Iterator;

import java.util.NoSuchElementException;



import javafx.application.Application;

import javafx.event.ActionEvent; import javafx.event.EventHandler;


import javafx.scene.Scene;
 

import javafx.scene.control.Button; import javafx.scene.control.TextField;
import javafx.scene.layout.HBox; import javafx.scene.layout.VBox;

import javafx.scene.text.Text; import javafx.stage.Stage;


public class Deque1<Item> extends Application implements Iterable<Item> { private Node first;
private Node last; private int size;
private static final Deque<String> deque = new Deque<>();



private class Node { Item item;
Node next; Node pre;
}

public Deque1() {
 
}

public boolean isEmpty() { return (this.size == 0);
}

public int size() { return this.size;
}

public void addFirst(Item item) { if (item == null)
throw new NullPointerException("item is null");



Node newNode = new Node(); newNode.item = item;


if (size == 0) {

first = newNode; last = newNode;
}

else {

newNode.next = first;
 
first.pre = newNode; first = newNode; newNode.pre = null;
}

this.size++;

}

public void addLast(Item item) { if (item == null)
throw new NullPointerException("item is null");



Node newNode = new Node(); newNode.item = item;


if (size == 0) {

first = newNode; last = newNode;
}

else {

last.next = newNode; newNode.pre = last;
 
last = newNode; newNode.next = null;
}

size++;

}

public Item removeFirst() { if (size == 0)
throw new NoSuchElementException("Deque is empty");



Item returnItem = first.item;



if (size == 1) { first = null; last = null;
}

else {

first = first.next; first.pre = null;
}

size--;
 


return returnItem;

}

public Item removeLast() { if (size == 0)
throw new NoSuchElementException("Deque is empty"); Item returnItem = last.item;


if (size == 1) { first = null; last = null;
}

else {

last = last.pre; last.next = null;
}

size--;

return returnItem;

}

@Override
public Iterator<Item> iterator() {
 

return new ListIterator();

}



private class ListIterator implements Iterator<Item> { private Node cur = first;
@Override
public boolean hasNext() { return (cur != null);
}

@Override
public Item next() { if (!hasNext())
throw new NoSuchElementException("No more Objects in the deque");



Item returnItem = cur.item; cur = cur.next;


return returnItem;

}

}
 

public static void main(String[] args) { System.out.println("SIZE ::: "+deque.size()); launch(args);
}

@Override

public void start(Stage primaryStage) throws Exception { primaryStage.setTitle("Deque");
VBox vbox1;
vbox1 = new VBox();

TextField textField = new TextField();


Text text1 = new Text(); Text text2 = new Text(); Button btn1 = new Button();

btn1.setText("Add Front");

btn1.setOnAction((ActionEvent event) -> { String number = textField.getText();
deque.addFirst(number);
text1.setText("Successfully Added Front Element : "+number+"\n"+"SIZE : "+deque.size());


System.out.println("SIZE ::: "+deque.size()); String queueElements = "";
final Iterator<String> iter = deque.iterator();

while (iter.hasNext()) {
 

final String element = iter.next(); queueElements += element+" ";

}
text2.setText("Elements in Queue : "+queueElements);
});

Button btn2 = new Button(); btn2.setText("Add Rear");
btn2.setOnAction((ActionEvent event) -> { String number = textField.getText(); deque.addLast(number);

text1.setText("Successfully Added Rear Element : "+number+"\n"+"SIZE : "+deque.size()); System.out.println("SIZE ::: "+deque.size());

String queueElements = "";
final Iterator<String> iter = deque.iterator(); while (iter.hasNext()) {
final String element = iter.next(); queueElements += element+" ";

}
text2.setText("Elements in Queue : "+queueElements);
});


Button btn3 = new Button(); btn3.setText("Remove Front");
btn3.setOnAction((ActionEvent event) -> { String removeFirst = deque.removeFirst();
text1.setText("Successfully Removed Front Element : "+removeFirst+"\n"+"SIZE : "+deque.size());
 
System.out.println("Removed Front Element : "+removeFirst); System.out.println("SIZE ::: "+deque.size());

String queueElements = "";
final Iterator<String> iter = deque.iterator(); while (iter.hasNext()) {
final String element = iter.next(); queueElements += element+" ";

}
text2.setText("Elements in Queue : "+queueElements);
});

Button btn4 = new Button(); btn4.setText("Remove Rear");
btn4.setOnAction((ActionEvent event) -> { String removeLast = deque.removeLast();
text1.setText("Successfully Removed Rear Element : "+removeLast+"\n"+"SIZE : "+deque.size());

System.out.println("Removed Rear Element : "+removeLast);


System.out.println("SIZE ::: "+deque.size()); String queueElements = "";
final Iterator<String> iter = deque.iterator(); while (iter.hasNext()) {
final String element = iter.next(); queueElements += element+" ";

}
text2.setText("Elements in Queue : "+queueElements);
 
});



Text text = new Text(); Button btn5 = new Button();
btn5.setText("Final Result"); btn5.setOnAction((ActionEvent event) -> {
text.setText("The Element Present in Double Ended Queue is : \n");

Iterator<String> iterator = deque.iterator(); while(iterator.hasNext()) {
//System.out.println(iterator.next());



String elements = text.getText();



String element = iterator.next(); text.setText(elements+" "+element);
}
});

vbox1.getChildren().addAll(textField, btn1, btn2, btn3, btn4, text1, text2, btn5, text);



Scene scene1;
scene1 = new Scene(vbox1, 500, 500); primaryStage.setScene(scene1);
 
primaryStage.show();

}

}
