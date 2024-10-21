package sort;

import utils.SortUtils;

/**
 * <h3> 퀵 정렬의 동작 원리 </h3>
 * <p>
 * 1. 피벗 선택: 배열에서 임의의 요소를 선택해 피벗으로 설정합니다. <br/>
 * 2. 분할: 피벗보다 작은 요소들은 왼쪽에, 피벗보다 큰 요소들은 오른쪽에 배치하여 배열을 두 부분으로 나눕니다. <br/>
 * 3. 재귀 호출: 피벗을 제외한 나머지 부분을 각각 재귀적으로 퀵 정렬합니다. <br/>
 * 4. 정렬 완료: 재귀 호출이 끝나면 배열이 정렬됩니다.
 * <p>
 * <h3> 퀵 정렬의 특징 </h3>
 * <p>
 * 시간 복잡도: O(n \log n) (평균), O(n^2) (최악의 경우) <br/>
 * 비교 기반 정렬: 피벗을 기준으로 비교하여 정렬 <br/>
 * 불안정 정렬: 동일한 값을 가진 요소들의 상대적 순서가 보존되지 않음 <br/>
 * 적용 가능성: 대부분의 경우 빠른 성능을 보이며, 특히 대규모 데이터셋에 적합
 */
public class QuickSort
{
    public <T extends Comparable<T>> void quickSort(T[] arr, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high); // 피벗의 위치 반환

            // 피벗을 기준으로 왼쪽과 오른쪽을 재귀적으로 정렬
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // 배열을 피벗 기준으로 분할하는 메서드
    private <T extends Comparable<T>> int partition(T[] arr, int low, int high)
    {
        T pivot = arr[high]; // 마지막 요소를 피벗으로 설정
        int i = low - 1; // 작은 요소들을 저장할 인덱스

        for (int j = low; j < high; j++)
        {
            // 현재 요소가 피벗보다 작거나 같으면 swap
            if (arr[j].compareTo(pivot) <= 0)
            {
                i++;
                swap(arr, i, j);
            }
        }

        // 피벗을 제 위치에 삽입
        swap(arr, i + 1, high);

        return i + 1; // 새로운 피벗의 위치 반환
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

        quickSort(array, 0 , array.length - 1);

        long endTime = System.currentTimeMillis();   // 정렬 후 시간 측정 종료

        long duration = endTime - startTime; // 실행 시간 계산 (밀리초 단위)

        SortUtils.printArray(array, "정렬 후");

        // 결과 출력
        System.out.println("정렬 실행 시간: " + duration + " 밀리초");
    }

    public static void main(String[] args)
    {
        QuickSort quickSort = new QuickSort();

        // 실험 대상 설정
        System.out.println("Random Array Quick Sort");
        Integer[] randomArray = SortUtils.getRandomArray();
        quickSort.checkRunTime(randomArray);

        System.out.println();

        System.out.println("Sorted Array Quick Sort");
        Integer[] sortedArray = SortUtils.getSortedArray();
        quickSort.checkRunTime(sortedArray);
    }
}
