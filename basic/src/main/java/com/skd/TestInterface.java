package com.skd;

import org.springframework.stereotype.Service;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2020/3/25 14:52
 */
public interface TestInterface {
}

@Service
class One implements TestInterface{

}
@Service
class Two implements TestInterface{

}
@Service
class Three implements TestInterface{

}

