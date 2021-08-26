package com.api.reactive.service;

import java.util.Map.Entry;

import org.springframework.data.domain.Range;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ReactiveRedisService {

	private ReactiveRedisOperations<String, Object> redisOps;

	public Mono<Object> getStringValue(String param) {
		return redisOps.opsForValue().get(param);
	}

	public Flux<Entry<Object, Object>> getHash(String param) {
		return redisOps.opsForHash().entries(param);
	}

	public Flux<Object> getList(String param) {
		return redisOps.opsForList().range(param, 0, -1);
	}

	public Flux<TypedTuple<Object>> getSortedSet(String param) {
		return redisOps.opsForZSet().reverseRangeByScoreWithScores(param, Range.unbounded());
	}

	public Flux<Object> keys() {
		return redisOps.keys("*").flatMap(key -> redisOps.scan());
	}

}
