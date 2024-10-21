package sort;

import utils.SortUtils;

/**
 * <h3> 삽입 정렬의 동작 원리 </h3>
 * <p>
 * 1. 첫 번째 요소: 배열의 첫 번째 요소는 이미 정렬된 상태로 간주합니다. <br/>
 * 2. 다음 요소 삽입: 두 번째 요소부터 시작하여 이전 요소들과 비교하면서 올바른 위치에 삽입합니다. <br/>
 * 3. 반복: 세 번째, 네 번째 요소 등 모든 요소가 제자리를 찾을 때까지 이 과정을 반복합니다. <br/>
 * 4. 정렬 완료: 배열이 모두 정렬되면 알고리즘이 종료됩니다.
 * <p>
 * <h3> 삽입 정렬의 특징 </h3>
 * <p>
 * 시간 복잡도: O(n²) (최악의 경우), O(n) (최선의 경우) <br/>
 * 안정성: 안정 정렬 (stable sort), 동일한 값을 가진 요소들의 상대적 순서가 보존됨 <br/>
 * 적용 가능성: 대부분 정렬된 데이터에 적합하며, 비교적 작은 데이터셋에서 사용하기 적합
 */
public class InsertionSort
{
    public <T extends Comparable<T>> void insertionSort(T[] arr)
    {

        for (int i = 1; i < arr.length; i++)
        {
            T current = arr[i];
            int j = i - 1;

            // 이전 요소들과 비교하며 적절한 위치 찾기
            while (j >= 0 && arr[j].compareTo(current) > 0)
            {
                arr[j + 1] = arr[j];  // 큰 요소를 오른쪽으로 이동
                j--;
            }

            // 적절한 위치에 현재 요소 삽입
            arr[j + 1] = current;
        }
    }

    public <T extends Comparable<T>> void checkRunTime(T[] array)
    {
        SortUtils.printArray(array, "정렬 전");

        long startTime = System.currentTimeMillis(); // 정렬 전 시간 측정 시작

        insertionSort(array);

        long endTime = System.currentTimeMillis();   // 정렬 후 시간 측정 종료

        long duration = endTime - startTime; // 실행 시간 계산 (밀리초 단위)

        SortUtils.printArray(array, "정렬 후");

        // 결과 출력
        System.out.println("정렬 실행 시간: " + duration + " 밀리초");
    }


    public static void main(String[] args)
    {
        System.out.println("Insertion Sort Start!!");

        InsertionSort insertionSort = new InsertionSort();

        // 실험 대상 설정
        System.out.println("Random Array Insertion Sort");
        Integer[] randomArray = SortUtils.getRandomArray();
        insertionSort.checkRunTime(randomArray);

        System.out.println();

        System.out.println("Sorted Array Insertion Sort");
        Integer[] sortedArray = SortUtils.getSortedArray();
        insertionSort.checkRunTime(sortedArray);
    }
}