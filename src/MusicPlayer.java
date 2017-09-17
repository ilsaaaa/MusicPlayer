
import java.util.*;
import java.util.Random;

class musicNode {
    String track;  // The name of the track
    int played= 0; // The number of times played
    int shuffleTag= 0; // For shuffling
    musicNode next; //next node
    
    public musicNode() {		// Here's how we construct an empty list.
        next = null;
    }
    public musicNode(String t) {
        track = t; next = null;    //short form of track 
    }
    public musicNode(String t, musicNode ptr) { //empty list has a value ptr
        track = t; next = ptr;
    }
    
     public boolean LTTrack(musicNode x) {   // Compares tracks according to alphabetical order on strings
    	 if (this.track.compareTo(x.track)<=0) return true;
    	 else return false;
     }
     
     public boolean LTPlayed(musicNode x) {   // Compares according to the played field.
    	 if (this.played <= x.played) return true; //number of times played 
    	 else return false;
     }
     
     public boolean LTTag(musicNode x) {   // Compares according to the shuffle tag.
    	 if (this.shuffleTag <= x.shuffleTag) return true;
    	 else return false;
     }
}; 

// This class represents a playlist;
// We assume that each track appears at most once in the playlist

public class MusicPlayer {
	protected musicNode head = null; // Pointer to the top of the list.
	int length=0;   // the number of nodes in the list.
    boolean debug= false;
    
    public  MusicPlayer() {
    }
    public void setToNull() {
        head = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public String firstTrack() {
        return head.track;
    }
    
    public int firstPlaycount() {
        return head.played;
    }
    
    public int firstTag() {
        return head.shuffleTag;
    }
       
    public musicNode head() {
        return head;
    }
    public void printAll() 
    {   for (musicNode tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(tmp.track.toString());
            System.out.print('\n');
    }
    
    void playTrack(String name){  // Simulates playing a track: searches for the name and increments its played field
    	musicNode tmp = head;
    	for (; tmp != null && (tmp.track.compareTo(name)!=0); tmp = tmp.next) {
    		
    	}
            if (tmp!= null) tmp.played= tmp.played+1;   	
    }
    
    void insertTrack(String name) { // Inserts a new track at the top of the list.
    	musicNode temp= new musicNode(name, head);
    	head= temp;
        length++;
   }
    
    void sortTrack() { // TODO
    	// Sorts (ascending) the list according to the name of the track
    	if(head!=null)
    	head = mergeSort(head);
    	
    	}
    	
  //The main function
    musicNode mergeSort(musicNode head) {
        if(head == null || head.next == null) { 
        	
        return head; }
        musicNode middle = getMiddle(head);  //get the middle of the list
        musicNode Half = middle.next; //go to the next node
        
        middle.next = null;   //split the list into two half

        return merge(mergeSort(head),mergeSort(Half));  //recurse on that
    }

    //Merge subroutine to merge two sorted lists
    musicNode merge(musicNode a, musicNode b) {
        musicNode tmp; 
        head = new musicNode();
        
        tmp = head;
        while(a !=null && b!= null) {
            if(a.LTTrack(b) && a.LTTag(b) && a.LTPlayed(b)) { 
            	tmp.next = a; 
            	tmp = a;
            	a = a.next; }
            
            else { 
            tmp.next = b; 
            b = b.next; 
            tmp = tmp.next;
        }}
        if(b == null)
        	tmp.next = a;
        else
        	tmp.next = b;
        return head.next;
}

    //Finding the middle element of the list for splitting
     musicNode getMiddle(musicNode head) {
    	 
        if(head == null) {
        	return head; }
        
        musicNode left = head; 
        musicNode right = head;
       
        
        while(right.next != null && right.next.next != null) {
            left = left.next; 
            right = right.next.next;
        }
        return left;  
    }
  
    
    void sortPlayed() {  // This is optional but might be useful for shuffling.
    	// Sorts (ascending) the list according to the number of times played
    	if(head!=null)
        	head = mergeSortPlay(this.head);
    	
    	}
    
    musicNode mergeSortPlay(musicNode head) {
        if(head == null || head.next == null) { 
        	
        return head; }
        musicNode middle = getMiddle(head);  //get the middle of the list
        musicNode Half = middle.next; //go to the next node
        
        middle.next = null;   //split the list into two half

        return mergePlay(mergeSortPlay(head),mergeSortPlay(Half));  //recurse on that
    }

    //Merge subroutine to merge two sorted lists
    musicNode mergePlay(musicNode a, musicNode b) {
        musicNode tmp; 
        head = new musicNode();
        
        tmp = head;
        while(a !=null && b!= null) {
            if(a.LTPlayed(b)) { 
            	tmp.next = a; 
            	tmp = a;
            	a = a.next; }
            
            else { 
            tmp.next = b; 
            b = b.next; 
            tmp = tmp.next;
        }}
        if(b == null)
        	tmp.next = a;
        else
        	tmp.next = b;
        return head.next;
}
    
    
   
    
    int countItem(String item) {  // TODO
    	// Returns the number of times that item occurs in the current list
    	musicNode start = head;
    	int count = 0;
    	
    	for (; start!=null; start = start.next){
    		if(item.equals(start.track)==true){
    			count++;
    		}
    	}
    	//System.out.println("the value" + count);
    	return count;
    	
    }
     
    musicNode checkMembership(String _track) { // TODO
    	// If the given _track is present in the current list (i.e. the node whose "track" field
    	// is equal to _track), returns the address of that node;
    	// otherwise returns null. 
    	musicNode tmp = head;
    	
    	while(tmp !=null){
    		if(_track.equals(tmp.track)){
    			return tmp;
    		}else{
    			tmp=tmp.next;
    		}
    	}
    	return null;
    }
    
    void shuffle() {  // TODO
    	// Randomly shuffles the list
    	Random randomShuffle = new Random();
    	musicNode randomG = head;
    	
    	while(randomG !=null){
    		int randomint= randomShuffle.nextInt(length);
    		randomG.shuffleTag = randomint; //assign random values for each items
    		randomG = randomG.next;
    	
    	}
 
		// Randomly shuffles the list
		head = mergeSort(head);
	}
    	
    
    
    void smartShuffle () {  // TODO
    	// Shuffles the list, whilst respecting the special condition on played
    	if(head!=null)
        	head = mergeSort(head);
    	
    }
    
    void recommended(String[] historyList) { // TODO
    
    	musicNode tmp = head;
    	musicNode prev = null;
    	
    	while(tmp!=null){
        	for(int i = 0; i<historyList.length;i++){ //goes through the list
        	
        	if((historyList[i].compareTo(tmp.track)==0)){
        		tmp.played--;
        	}}
    	if (tmp.played==0){
    		if(tmp==head){
    			head = head.next;
    		}else{
    			prev.next = tmp.next; //delete 
    		}}
    	prev = tmp;
    	tmp = tmp.next;
    }
    	sortPlayed();
    }
    	
    
    
    void moveFirstNode(MusicPlayer fromList, MusicPlayer toList) { // TODO  
    	// Removes the top node of fromList and puts it onto (the top of) toList.
    	// If fromList is empty, it does nothing.
    	
  
    	if (!fromList.isEmpty()) { //if the first list is empty
			toList.insertTrack(fromList.firstTrack()); //insert the head into the second list
			fromList.length--; //delete the node
    	    fromList.head = fromList.head.next; //move to the next node
    		
    	}}
    	
    }




