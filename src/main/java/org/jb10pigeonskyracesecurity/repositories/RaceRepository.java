package org.jb10pigeonskyracesecurity.repositories;

import org.jb10pigeonskyracesecurity.models.Breeder;
import org.jb10pigeonskyracesecurity.models.Race;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaceRepository extends MongoRepository<Race, String> {

    @Aggregation(pipeline = {
            "{ $match: { _id: ObjectId(?0) } }",
            "{ $lookup: { from: 'rankings', localField: '_id', foreignField: 'race.$id', as: 'raceRankings' } }",
            "{ $unwind: '$raceRankings' }",
            "{ $lookup: { from: 'pigeons', localField: 'raceRankings.pigeon.$id', foreignField: '_id', as: 'pigeon' } }",
            "{ $unwind: '$pigeon' }",
            "{ $lookup: { from: 'breeders', localField: 'pigeon.breeder.$id', foreignField: '_id', as: 'breeder' } }",
            "{ $unwind: '$breeder' }",
            "{ $group: { _id: '$breeder._id', breeder: { $first: '$breeder' } } }",
            "{ $replaceRoot: { newRoot: '$breeder' } }"
    })
    List<Breeder> findDistinctLoftsByRaceId(String raceId);
}
