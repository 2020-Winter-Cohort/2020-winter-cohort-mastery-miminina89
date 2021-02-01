package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import org.springframework.stereotype.Service;

@Service
public class HashtagStorageJpaImpl  {
private HashtagRepository hashtagRepo;

    public HashtagStorageJpaImpl(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    public Iterable<Hashtag> retrieveAllHashtag() {
        return hashtagRepo.findAll();
    }


    public Hashtag retrieveHashtagById(long id) {
        return hashtagRepo.findById(id).get();
    }


    public void save(Hashtag hashtagToAdd) {
            hashtagRepo.save(hashtagToAdd);
    }
}
