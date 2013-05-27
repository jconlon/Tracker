use test
db.Tag.aggregate([
 {$unwind:"$events"},
 {$group: 
	{
		_id: "$events.pid",
		"count":{$sum:1}
	}
 },
 {"$project" : 
	{_id:0, "pid":"$_id", "count": 1}

 }
 
])
