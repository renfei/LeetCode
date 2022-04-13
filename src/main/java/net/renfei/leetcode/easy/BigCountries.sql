-- 595. 大的国家
-- OR 会使索引失效，用 UNION 效率更高
-- https://leetcode-cn.com/problems/big-countries/
SELECT name, population, area
FROM world
WHERE area >= 3000000
UNION
SELECT name, population, area
FROM world
WHERE population >= 25000000;