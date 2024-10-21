package sort;

import utils.SortUtils;

/**
 * <h3> 선택 정렬의 동작 원리 </h3>
 * <p>
 * 1. 최솟값(혹은 최댓값) 찾기: 배열의 첫 번째 요소부터 마지막 요소까지 탐색하면서 최솟값을 찾습니다. <br/>
 * 2. 교환: 찾은 최솟값을 배열의 첫 번째 요소와 교환합니다. <br/>
 * 3. 반복: 그다음 두 번째 위치부터 같은 과정을 반복합니다. <br/>
 * 4. 정렬 완료: 배열의 모든 요소가 정렬되면 알고리즘이 종료됩니다.
 * <p>
 * <h3> 선택 정렬의 특징 </h3>
 * <p>
 * 시간 복잡도: O(n²) (최선, 평균, 최악 모두 동일) <br/>
 * 안정성: 불안정 정렬(unstable sort), 동일한 값을 가진 요소의 상대적 순서를 보장하지 않음 <br/>
 * 적용 가능성: 작은 데이터셋에서 적합하며, 단순 구현이 필요할 때 유용
 */
public class SelectionSort
{
    public <T extends Comparable<T>> T[] selectionSort(T[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            // i번째 이후 요소 중 최솟값 찾기
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j].compareTo(arr[minIndex]) < 0)
                {
                    minIndex = j;
                }
            }
            // 최솟값을 현재 위치와 교환
            swap(arr, i, minIndex);
        }
        return arr;
    }

    // 배열의 두 요소를 교환하는 메서드
    private <T> void swap(T[] arr, int i, int j)
    {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public <T extends Comparable<T>> void checkRunTime(T[] array)
    {
        SortUtils.printArray(array, "정렬 전");

        long startTime = System.currentTimeMillis(); // 정렬 전 시간 측정 시작

        selectionSort(array);

        long endTime = System.currentTimeMillis();   // 정렬 후 시간 측정 종료

        long duration = endTime - startTime; // 실행 시간 계산 (밀리초 단위)

        SortUtils.printArray(array, "정렬 후");

        // 결과 출력
        System.out.println("정렬 실행 시간: " + duration + " 밀리초");
    }

    public static void main(String[] args)
    {
        System.out.println("Selection Sort Start!!");

        SelectionSort selectionSort = new SelectionSort();

        // 실험 대상 설정
        System.out.println("Random Array Selection Sort");
        Integer[] randomArray = SortUtils.getRandomArray();
        selectionSort.checkRunTime(randomArray);

        System.out.println();

        System.out.println("Sorted Array Selection Sort");
        Integer[] sortedArray = SortUtils.getSortedArray();
        selectionSort.checkRunTime(sortedArray);
    }
}
