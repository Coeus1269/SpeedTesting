package SpeedTests;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Set;

import Utils.Timer;

public class HashTests 
{
//						Hash Table	Hash Map	Linked Hash Map
// Time to load 100 k	35ms		45ms		58ms
// Time to load 1 mil	153ms		146ms		144ms
// Time to load 2 mil	205ms		139ms		170ms
// Time to load 3 mil	1599ms		1664ms		1246ms
// Time to load 5 mil	1568ms		1435ms		1210ms
// Time to load 10 mil	4281ms		4357ms		2889ms

//	HashMap makes absolutely no guarantees about the iteration order. It can (and will) even change 
//		completely when new elements are added.
//	TreeMap will iterate according to the "natural ordering" of the keys according to their 
//		compareTo() method (or an externally supplied Comparator). Additionally, it implements the 
//		SortedMap interface, which contains methods that depend on this sort order.
//	LinkedHashMap will iterate in the order in which the entries were put into the map
	
//	"Hashtable" is the generic name for hash-based maps. In the context of the Java API, 
//	Hashtable is an obsolete class from the days of Java 1.1 before the collections framework existed.
	
	Random rand = new Random();
	long TestLoop = 100000; // test size
	Timer timer = new Timer();
	Hashtable<Long, Integer> hashTable = new Hashtable<Long, Integer>();
	HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
	LinkedHashMap<Long, Integer> LHM = new LinkedHashMap<Long, Integer>();
	
	public static void main(String[] args) 
	{
		HashTests MT1 = new HashTests();
		// MT1.RunHashTableTests();
		// MT1.RunHashMapTests();
		 MT1.RunLinkedHashMapTests();
		
	}
	
	public void RunLinkedHashMapTests()
	{
		LogOut("Time to load 100 k");
		LinkedHashMapLoadTester();
		Clear();
	
		LHM = new LinkedHashMap<Long, Integer>();
		setTestLoop((long) 1000000);
		LogOut("Time to load 1 mil");
		LinkedHashMapLoadTester();
		Clear();
		
		LHM = new LinkedHashMap<Long, Integer>();
		setTestLoop((long)2000000);
		LogOut("Time to load 2 mil");
		LinkedHashMapLoadTester();
		Clear();
		
		LHM = new LinkedHashMap<Long, Integer>();
		setTestLoop((long)3000000);
		LogOut("Time to load 3 mil");
		LinkedHashMapLoadTester();
		Clear();
		
		LHM = new LinkedHashMap<Long, Integer>();
		setTestLoop((long)5000000);
		LogOut("Time to load 5 mil");
		LinkedHashMapLoadTester();
		Clear();
		
		LHM = new LinkedHashMap<Long, Integer>();
		setTestLoop((long)10000000);
		LogOut("Time to load 10 mil");
		LinkedHashMapLoadTester();
		Clear();
		
		// MT.HashTableOrderTester();
	}
	
	public void LinkedHashMapLoadTester()
	{
	//         Random, Index
	Long Index_int = Long.MIN_VALUE;
	
	timer.StartTimer();
	  for(long LoopCount = 0; LoopCount < TestLoop; LoopCount++) 
	  	{
		  LHM.put(Index_int++, rand.nextInt(50));
		}
	  timer.EndTimer();
	  LogOut(timer.toString());
	}
	
	
	public void RunHashMapTests()
	{
		LogOut("Time to load 100 k");
		HashMapLoadTester();
		Clear();
	
		hashMap = new HashMap<Long, Integer>();
		setTestLoop((long) 1000000);
		LogOut("Time to load 1 mil");
		HashMapLoadTester();
		Clear();
		
		hashMap = new HashMap<Long, Integer>();
		setTestLoop((long)2000000);
		LogOut("Time to load 2 mil");
		HashMapLoadTester();
		Clear();
		
		hashMap = new HashMap<Long, Integer>();
		setTestLoop((long)3000000);
		LogOut("Time to load 3 mil");
		HashMapLoadTester();
		Clear();
		
		hashMap = new HashMap<Long, Integer>();
		setTestLoop((long)5000000);
		LogOut("Time to load 5 mil");
		HashMapLoadTester();
		Clear();
		
		hashMap = new HashMap<Long, Integer>();
		setTestLoop((long)10000000);
		LogOut("Time to load 10 mil");
		HashMapLoadTester();
		Clear();
		
		// MT.HashTableOrderTester();
	}
	
	public void HashMapLoadTester()
	{
	//         Random, Index
	Long Index_int = Long.MIN_VALUE;
	
	timer.StartTimer();
	  for(long LoopCount = 0; LoopCount < TestLoop; LoopCount++) 
	  	{
		  hashMap.put(Index_int++, rand.nextInt(50));
		}
	  timer.EndTimer();
	  LogOut(timer.toString());
	}
	
	public void RunHashTableTests()
	{
		LogOut("Time to load 100 k");
		HashTableLoadTester();
		Clear();
	
		hashTable = new Hashtable<Long, Integer>();
		setTestLoop((long) 1000000);
		LogOut("Time to load 1 mil");
		HashTableLoadTester();
		Clear();
		
		hashTable = new Hashtable<Long, Integer>();
		setTestLoop((long)2000000);
		LogOut("Time to load 2 mil");
		HashTableLoadTester();
		Clear();
		
		hashTable = new Hashtable<Long, Integer>();
		setTestLoop((long)3000000);
		LogOut("Time to load 3 mil");
		HashTableLoadTester();
		Clear();
		
		hashTable = new Hashtable<Long, Integer>();
		setTestLoop((long)5000000);
		LogOut("Time to load 5 mil");
		HashTableLoadTester();
		Clear();
		
		hashTable = new Hashtable<Long, Integer>();
		setTestLoop((long)10000000);
		LogOut("Time to load 10 mil");
		HashTableLoadTester();
		Clear();
		
		// MT.HashTableOrderTester();
	}
	
	public void HashTableLoadTester()
		{
		//         Random, Index
		Long Index_int = Long.MIN_VALUE;
		
		timer.StartTimer();
		  for(long LoopCount = 0; LoopCount < TestLoop; LoopCount++) 
		  	{
			  hashTable.put(Index_int++, rand.nextInt(50));
			}
		  timer.EndTimer();
		  LogOut(timer.toString());
		}
	
	public void HashTableOrderTester()
		{
		Set<Long> keys = hashTable.keySet();
		timer.StartTimer();
        for(Long key: keys)
        	{
            System.out.println("Value of "+key+" is: "+hashTable.get(key));
        	}
		  timer.EndTimer();
		  LogOut("Timer: " + timer.toString());
		}
	
	public void Clear()
		{
			hashTable.clear();
			hashMap.clear();
		}
	
	public static void LogOut(String String_str)
		{
			System.out.println(String_str);
		}

	public Long getTestLoop() 
		{
			return TestLoop;
		}

	public void setTestLoop(Long testLoop) 
		{
			TestLoop = testLoop;
		}

}

