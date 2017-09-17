
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;

public class MusicTests {
	
	@Test
	public void testMoveFirstNode() {
		MusicPlayer trackListOne= new MusicPlayer(); //in the class 
		MusicPlayer trackListTwo= new MusicPlayer();
		 
		 // add some tunes;
		 
		 trackListOne.insertTrack("a");
		 trackListOne.insertTrack("b");
		 trackListOne.insertTrack("c");
		 trackListTwo.insertTrack("d");
		 trackListTwo.insertTrack("e");
		 trackListTwo.insertTrack("f");

		 trackListOne.moveFirstNode(trackListOne, trackListTwo);
		 assertTrue(trackListTwo.firstTrack().equals("c")); //track.head e.g c,b,a,d,e,f
	}
	
	@Test
	public void testMoveFirstNodeTwo() {
		MusicPlayer trackListOne= new MusicPlayer();
		MusicPlayer trackListTwo= new MusicPlayer();
		 
		 // add some tunes;
		 
		 trackListOne.insertTrack("a");
		 trackListOne.insertTrack("b");
		 trackListOne.insertTrack("c");
		 trackListTwo.insertTrack("d");
		 trackListTwo.insertTrack("e");
		 trackListTwo.insertTrack("f");

		 trackListOne.moveFirstNode(trackListOne, trackListTwo);
		 assertEquals("b",trackListOne.firstTrack());
	}
	
	@Test
	public void testMoveFirstNodefromListEmpty() {
		MusicPlayer trackListOne= new MusicPlayer();
		MusicPlayer trackListTwo= new MusicPlayer();
		 
		 // add some tunes;
	
		 trackListTwo.insertTrack("d");
		 trackListTwo.insertTrack("e");
		 trackListTwo.insertTrack("f"); //f,e,d ??
		 

		 trackListOne.moveFirstNode(trackListOne, trackListTwo);
		 assertEquals("f",trackListTwo.firstTrack()); //head.track
		 assertEquals (trackListOne.head, null);
	}
	
	@Test
	public void testMoveFirstNodetoListEmpty() {
		MusicPlayer trackListOne= new MusicPlayer();
		MusicPlayer trackListTwo= new MusicPlayer();
		 
		 // add some tunes;
		 
		 trackListTwo.insertTrack("d");
		 trackListTwo.insertTrack("e");
		 trackListTwo.insertTrack("f");

		 trackListOne.moveFirstNode(trackListTwo, trackListOne);
		 assertEquals("e",trackListTwo.firstTrack());
		 assertEquals ("f", trackListOne.firstTrack());
	}
	
	@Test
	public void testSortMixed() {	
		MusicPlayer trackList= new MusicPlayer();
		trackList.insertTrack("d");
		trackList.insertTrack("b");
		trackList.insertTrack("e");
		trackList.insertTrack("a");
		trackList.insertTrack("c");
	
		MusicPlayer trackListTwo= new MusicPlayer();
		trackListTwo.insertTrack("e");
		trackListTwo.insertTrack("d");
		trackListTwo.insertTrack("c");
		trackListTwo.insertTrack("b");
		trackListTwo.insertTrack("a");
		
	    trackList.sortTrack();
	    musicNode tmp= trackList.head;
	    musicNode tmp2= trackListTwo.head;
	    for(int i=0; i< 5; i++){
	    	assertEquals(tmp2.track, tmp.track);
	    	tmp2= tmp2.next;
	    	tmp=tmp.next;
	    }
	}    
	    @Test
		public void testSortSorted() {	
			MusicPlayer trackList= new MusicPlayer();
			trackList.insertTrack("e");
			trackList.insertTrack("d");
			trackList.insertTrack("c");
			trackList.insertTrack("b");
			trackList.insertTrack("a");
		
			MusicPlayer trackListTwo= new MusicPlayer();
			trackListTwo.insertTrack("e");
			trackListTwo.insertTrack("d");
			trackListTwo.insertTrack("c");
			trackListTwo.insertTrack("b");
			trackListTwo.insertTrack("a");
			
		    trackList.sortTrack();
		    musicNode tmp= trackList.head;
		    musicNode tmp2= trackListTwo.head;
		    for(int i=0; i< 5; i++){
		    	assertEquals(tmp2.track, tmp.track);
		    	tmp2= tmp2.next;
		    	tmp=tmp.next;
		    }  
	}
	 
	    
	    @Test
		public void testSortEmpty() {	
			MusicPlayer trackList= new MusicPlayer();			
		    trackList.sortTrack();
		    assertEquals(null, trackList.head);		   
	}
	 
	    @Test
	  	public void testSortOne() {	
	  		MusicPlayer trackList= new MusicPlayer();	
	  		trackList.insertTrack("e");
	  		trackList.sortTrack();
	  		assertEquals("e", trackList.firstTrack());		   
	  	}
   
	    @Test
		public void testCountItem() {	
			MusicPlayer trackList= new MusicPlayer();
			trackList.insertTrack("e");
			trackList.insertTrack("d");
			trackList.insertTrack("e");
			trackList.insertTrack("b");
			trackList.insertTrack("a");
			
		    assertEquals(2, trackList.countItem("e"));		    
	}
	    
	    @Test
		public void testCountItemNull() {	
			MusicPlayer trackList= new MusicPlayer();
			trackList.insertTrack("e");
			trackList.insertTrack("d");
			trackList.insertTrack("e");
			trackList.insertTrack("b");
			trackList.insertTrack("a");			
		    assertEquals(0, trackList.countItem("z"));		    
	} 
	    
	    @Test
		public void testCheckMembershipFalse() {	
			MusicPlayer trackList= new MusicPlayer();
			trackList.insertTrack("e");
			trackList.insertTrack("d");
			trackList.insertTrack("e");
			trackList.insertTrack("b");
			trackList.insertTrack("a");			
		    assertEquals(null, trackList.checkMembership("z"));		    
	}  
	    
	    @Test
		public void testCheckMembershipTrue() {	
			MusicPlayer trackList= new MusicPlayer();
			trackList.insertTrack("e");
			trackList.insertTrack("d");
			trackList.insertTrack("e");
			trackList.insertTrack("b");
			trackList.insertTrack("a");			
		    assertEquals("b", trackList.checkMembership("b").track);		    
	}   
	    
	    @Test
			public void testShuffleItemsNotLost() {	
				MusicPlayer trackList= new MusicPlayer();
				trackList.insertTrack("e");
				trackList.insertTrack("d");
				trackList.insertTrack("c"); //this was an e before
				trackList.insertTrack("b");
				trackList.insertTrack("a");	
				ArrayList<String> members= new ArrayList<String>();
				members.add("a");
				members.add("b");
				members.add("c");
				members.add("d");
				members.add("e");
				
				trackList.shuffle();
				
				for(musicNode tmp= trackList.head; tmp!=null; tmp=tmp.next) {
					assertEquals(true, members.contains(tmp.track));
				}		    
		}   
	    
	    @Test
		public void testShuffleItemsDifferent() {	
			MusicPlayer trackList= new MusicPlayer();
			
			trackList.insertTrack("e");
			trackList.insertTrack("d");
			trackList.insertTrack("e");
			trackList.insertTrack("b");
			trackList.insertTrack("a");	
			
			MusicPlayer trackList2= new MusicPlayer();
			trackList2.insertTrack("e");
			trackList2.insertTrack("d");
			trackList2.insertTrack("e");
			trackList2.insertTrack("b");
			trackList2.insertTrack("a");	
			
			Boolean t1= true;
			Boolean t2= true;
			Boolean t3= true;
			
			trackList.shuffle();
			musicNode tmp2= trackList2.head;
			for(musicNode tmp= trackList.head; tmp!=null; tmp=tmp.next) {
				if (!tmp.track.equals(tmp2.track)) {
					t1= false;
				}
				tmp2= tmp2.next;
			}	
			trackList.shuffle();
			tmp2= trackList2.head;
			for(musicNode tmp= trackList.head; tmp!=null; tmp=tmp.next) {
				if (!tmp.track.equals(tmp2.track)) {
					t2= false;
				}
				tmp2= tmp2.next;
			}	
			
			trackList.shuffle();
			tmp2= trackList2.head;
			for(musicNode tmp= trackList.head; tmp!=null; tmp=tmp.next) {
				if (!tmp.track.equals(tmp2.track)) {
					t3= false;
				}
				tmp2= tmp2.next;
			}
			
			assertEquals(false, t1 && t2 && t3);			
	} 

	    @Test
		public void testSmartShuffleItemsNotLost() {	
			MusicPlayer trackList= new MusicPlayer();
			
			trackList.insertTrack("a");
			trackList.insertTrack("b");
			trackList.insertTrack("c");
			trackList.insertTrack("d");
			trackList.insertTrack("e");	
			trackList.playTrack("b");trackList.playTrack("b");
			trackList.playTrack("c");trackList.playTrack("c");trackList.playTrack("c");
			trackList.playTrack("d");trackList.playTrack("d");trackList.playTrack("d");trackList.playTrack("d");
			trackList.playTrack("e");trackList.playTrack("e");trackList.playTrack("e");trackList.playTrack("e");trackList.playTrack("e");
			
			ArrayList<String> members= new ArrayList<String>();
			members.add("a");
			members.add("b");
			members.add("c");
			members.add("d");
			members.add("e");
				
			trackList.smartShuffle();
			
			int i= 0;
			for(musicNode tmp= trackList.head; tmp!=null; tmp=tmp.next) {
				assertEquals(members.get(i), tmp.track);
				i++;
			}		    
	}
	    
	    @Test
			public void testSmartShuffleOrder() {	
				MusicPlayer trackList= new MusicPlayer();
				
				trackList.insertTrack("a");
				trackList.playTrack("a");
				trackList.insertTrack("z");
				trackList.playTrack("z");
				
				trackList.insertTrack("e");
				trackList.playTrack("e");
				trackList.playTrack("e");
				trackList.playTrack("e");
							
				trackList.insertTrack("c");	
				trackList.playTrack("c");
				trackList.playTrack("c");
				
				trackList.insertTrack("b");
				trackList.playTrack("b");
				trackList.playTrack("b");
				trackList.playTrack("b");
				
				trackList.smartShuffle();
				
				musicNode tmp= trackList.head; 
				
				ArrayList<String> first= new ArrayList<String>();
				first.add("a");
				first.add("z");
				assertEquals(true, first.contains(tmp.track));
				tmp= tmp.next;
				assertEquals(true, first.contains(tmp.track));
				
				tmp= tmp.next;
				assertEquals("c", tmp.track);
				
				tmp= tmp.next;
				ArrayList<String> third= new ArrayList<String>();
				third.add("b");
				third.add("e");
				
				assertEquals(true, third.contains(tmp.track));
				tmp= tmp.next;
				assertEquals(true, third.contains(tmp.track));				
		}		    
		
	    @Test
		public void testRecommendedStandard() {	
			MusicPlayer trackList= new MusicPlayer();
			String[] historyList= {"e", "e", "e", "e","c", "a", "c", "a", "c", "z"};
			
			trackList.insertTrack("a");
			trackList.insertTrack("z");			
			trackList.insertTrack("e");
			trackList.insertTrack("c");	

			trackList.recommended(historyList);
			
			String[] CorrectOrder= {"e", "c", "a", "z"};
			
			musicNode tmp= trackList.head; 
			int i= 0;
			for(; tmp!=null; tmp= tmp.next) {
				assertEquals(CorrectOrder[i], tmp.track);
				i++;
			}				
	}		    
	    
	    @Test
		public void testRecommendedHistoryLess() {	
			MusicPlayer trackList= new MusicPlayer();
			String[] historyList= {"e", "e", "e", "e","c", "a", "c", "a", "c"};
			
			trackList.insertTrack("a");
			trackList.insertTrack("z");			
			trackList.insertTrack("e");
			trackList.insertTrack("c");	

			trackList.recommended(historyList);
			
			String[] CorrectOrder= {"e", "c", "a"};
			
			musicNode tmp= trackList.head; 
			int i= 0;
			for(; tmp!=null; tmp= tmp.next) {
				assertEquals(CorrectOrder[i], tmp.track);
				i++;
			}				
	}		    
	    
	    @Test
		public void testRecommendedHistoryMore() {	
			MusicPlayer trackList= new MusicPlayer();
			String[] historyList= {"e", "e", "e", "e","c", "a", "c", "a", "c", "z"};
			
			trackList.insertTrack("a");		
			trackList.insertTrack("e");
			trackList.insertTrack("c");	

			trackList.recommended(historyList);
			
			String[] CorrectOrder= {"e", "c", "a"};
			
			musicNode tmp= trackList.head; 
			int i= 0;
			for(; tmp!=null; tmp= tmp.next) {
				assertEquals(CorrectOrder[i], tmp.track);
				i++;
			}				
	}		    
	    
}
