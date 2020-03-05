public class LinkNode{
  int position;
  String songName;
  LinkNode next;
  public LinkNode(int pos,String song){
    position =pos;
    songName=song;
    next=null;

  }
  void addSong(String song){
    songName=song;
  }
  void addPosition(int pos){
    position =pos;
  }
  int getPosition(){
    return position;
}
void setPosition(int newpos){
   position=newpos;
}
String getSong(){
  return songName;
}
void setNext(LinkNode e){
  next=e;
}
LinkNode getNext(){
  return next;
}
}